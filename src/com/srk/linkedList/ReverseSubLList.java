package com.srk.linkedList;

public class ReverseSubLList {

	public static class Node{
		public int data;
		public Node next = null;

		public Node(int n) {
			this.data = n;
		}

		@Override
		public String toString() {

			StringBuilder builder = new StringBuilder();

			Node n = this;
			while(n!=null) {
				builder.append(n.data).append("->");
				n=n.next;
			}
			builder.append("null");

			return builder.toString();
		}

	}

	public static void main(String[] args) {

		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(3);
		node.next.next.next = new Node(4);
		node.next.next.next.next = new Node(5);
		node.next.next.next.next.next = new Node(6);
		node.next.next.next.next.next.next = new Node(7);
		node.next.next.next.next.next.next.next = new Node(8);

		System.out.println(node);
		//System.out.println(reverse(node, 1, 6));

		Node reverseEveryKElements = reverseEveryKElements(node, 3);
		System.out.println(reverseEveryKElements);

	}

	public static Node reverseEveryKElements(Node head, int k) {

		if (k <= 1 || head == null)
			return head;

		Node current = head, previous = null;
		while (true) {
			Node lastNodeOfPreviousPart = previous;
			// after reversing the LinkedList 'current' will become the last node of the sub-list
			Node lastNodeOfSubList = current;
			Node next = null; // will be used to temporarily store the next node
			// reverse 'k' nodes
			for (int i = 0; current != null && i < k; i++) {
				next = current.next;
				current.next = previous;
				previous = current;
				current = next;
			}

			// connect with the previous part
			if (lastNodeOfPreviousPart != null)
				lastNodeOfPreviousPart.next = previous; // 'previous' is now the first node of the sub-list
			else // this means we are changing the first node (head) of the LinkedList
				head = previous;

			// connect with the next part
			lastNodeOfSubList.next = current;

			if (current == null) // break, if we've reached the end of the LinkedList
				break;
			// prepare for the next sub-list
			previous = lastNodeOfSubList;
		}

		return head;



		/*if(head == null || head.next == null)
			return head;

		Node pTail = null;
		Node cHead = null;
		Node cTail = null;
		Node next = null;

		Node h = head;

		while(h != null) {
			Node reversed = null;

			if(cTail == null)
				cTail = h;

			int n = k;
			while(n>0 && h!=null) {
				cHead = h;
				next = cHead.next;
				cHead.next = reversed;
				reversed = cHead;

				n--;
				h = next;
			}

			if(pTail == null)
				head = cHead;
			else
				pTail.next = cHead;
			cTail.next = next;
			pTail = cTail;
			cTail = null;
		}


		return head;*/
	}

	public static Node reverse(Node head, int p, int q) {
		if(p==q || head == null)
			return head;

		Node pTail = null;
		Node cHead = null;
		Node cTail = null;
		Node reversed = null;
		Node next = null;

		int i = 0;

		Node h = head;

		while(h!=null) {
			i++;

			if(i<p){
				pTail = h;
				h = h.next;
				continue;
			}

			if(i>=p && i<=q) {
				if(cTail == null){
					cTail = h;
				}

				cHead = h;
				next = cHead.next;
				cHead.next = reversed;
				reversed = cHead;

				if(i==q)
					break;

				h = next;
			}
		}

		if(pTail != null)
			pTail.next = cHead;
		else 
			head = cHead;
		cTail.next = next;

		return head;
	}

}
