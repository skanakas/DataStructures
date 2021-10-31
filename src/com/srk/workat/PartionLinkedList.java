package com.srk.workat;

class ListNode {
	int data;
	ListNode next;

	ListNode(int data) {
		this.data = data;
		this.next = null;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		ListNode dummy = this;
		while(dummy != null) {
			builder.append(dummy.data+"->");
			dummy = dummy.next;
		}
		builder.append("null");
		
		return builder.toString();
	}
}

public class PartionLinkedList {
	private static ListNode partitionList(ListNode head, int key) {

		if(head == null) return null;

		ListNode first = new ListNode(-1);
		ListNode second = new ListNode(-1);
		ListNode firstHead = first;
		ListNode secondHead = second;

		while(head!=null) {
			System.out.println(head.data);
			if(head.data == key) {
				ListNode temp = secondHead.next;
				secondHead.next = new ListNode(head.data);
				secondHead.next.next = temp;
			}
			else if(head.data < key) {
				first.next = new ListNode(head.data);
				first = first.next;
			} else {
				second.next = new ListNode(head.data);
				second = second.next;
			}
			System.out.println(firstHead.next);
			System.out.println(secondHead.next);
			head = head.next;
		}
		first.next = secondHead.next;
		return firstHead.next;
	}
	
	public static void main(String[] args) {
		//1 6 2 4 3 5 2 8 4 7
		
		ListNode head = new ListNode(1);
		ListNode node = head;
		node.next = new ListNode(6); node = node.next;
		node.next = new ListNode(2); node = node.next;
		node.next = new ListNode(4); node = node.next;
		node.next = new ListNode(3); node = node.next;
		node.next = new ListNode(5); node = node.next;
		node.next = new ListNode(2); node = node.next;
		node.next = new ListNode(8); node = node.next;
		node.next = new ListNode(4); node = node.next;
		node.next = new ListNode(7); node = node.next;
		
		System.err.println(head);
		
		System.out.println(partitionList(head, 5));
	}
}
