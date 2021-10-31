package com.srk.workat;


class ListNodeV2 {
	int data;
	ListNodeV2 next;

	ListNodeV2(int data) {
		this.data = data;
		this.next = null;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		ListNodeV2 dummy = this;
		while(dummy != null) {
			builder.append(dummy.data+"->");
			dummy = dummy.next;
		}
		builder.append("null");

		return builder.toString();
	}
}

public class PartionListV2 {



	static ListNodeV2 newNode(int data)
	{
		ListNodeV2 new_node = new ListNodeV2(data);
		new_node.next = null;
		return new_node;
	}

	static ListNodeV2 partition(ListNodeV2 head, int x)
	{

		ListNodeV2 firstHead = null, firstTail = null;
		ListNodeV2 scondTail = null, secondHead = null;
		ListNodeV2 equalHead = null, equalTail =null;

		while (head != null)
		{
			if (head.data == x)
			{
				if (equalHead == null)
					equalHead = equalTail = head;
				else
				{
					equalTail.next = head;
					equalTail = equalTail.next;
				}
			}

			else if (head.data < x)
			{
				if (firstHead == null)
					firstTail = firstHead = head;
				else
				{
					firstTail.next = head;
					firstTail = head;
				}
			}
			else
			{
				if (secondHead == null)
					scondTail = secondHead = head;
				else
				{
					scondTail.next = head;
					scondTail = head;
				}
			}
			head = head.next;
		}

		if (scondTail != null)
			scondTail.next = null;

		if (firstHead == null)
		{
			if (equalHead == null)
				return secondHead;
			equalTail.next = secondHead;
			return equalHead;
		}

		if (equalHead == null)
		{
			firstTail.next = secondHead;
			return firstHead;
		}

		firstTail.next = equalHead;
		equalTail.next = secondHead;
		return firstHead;
	}

	//Driver code
	public static void main(String[] args)
	{
		/* Start with the empty list */
		ListNodeV2 head = newNode(1);
		head.next = newNode(6);
		head.next.next = newNode(2);
		head.next.next.next = newNode(4);
		head.next.next.next.next = newNode(3);
		head.next.next.next.next.next = newNode(5);
		head.next.next.next.next.next.next = newNode(2);
		head.next.next.next.next.next.next.next = newNode(8);
		head.next.next.next.next.next.next.next.next = newNode(4);
		head.next.next.next.next.next.next.next.next.next = newNode(7);

		int x = 5;
		head = partition(head, x);
		System.out.println(head);
	}

}



