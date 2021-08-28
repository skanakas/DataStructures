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
		
		//reverse(node, 1, 9);
		
		reverseEveryKElements(node, 3);

	}
	
	public static Node reverseEveryKElements(Node head, int k) {
		if(head == null || head.next == null)
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
		
		
		return head;
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
