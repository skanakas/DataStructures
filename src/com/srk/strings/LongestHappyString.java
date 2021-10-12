package com.srk.strings;

import java.util.PriorityQueue;

class Node {
	public char c;
	public int count;
	public Node(char c, int count){
		this.c = c;
		this.count = count;
	}
}

public class LongestHappyString {

	private static String longestDiverseString(int a, int b, int c) {
		PriorityQueue<Node> maxHeap = new PriorityQueue<>((n1, n2) -> n2.count - n1.count);
		
		if(a>0)
			maxHeap.offer(new Node('a',a));
		if(b>0)
			maxHeap.offer(new Node('b',b));
		if(c>0)
			maxHeap.offer(new Node('c',c));

		StringBuilder str = new StringBuilder();

		while(!maxHeap.isEmpty()) {

			Node curr = maxHeap.poll();
			for(int i = 0; i<2 && curr.count>0; i++){
				str.append(curr.c);
				curr.count--;
			}

			System.out.println(str.toString());

			if(curr.count > 0 && !maxHeap.isEmpty()) {
				Node temp = maxHeap.peek();
				if(temp.count < curr.count) {
					temp = maxHeap.poll();
					str.append(temp.c);
					temp.count--;

					if(temp.count > 0){
						maxHeap.offer(temp);
					}
				}
				maxHeap.offer(curr);
			}
		}

		return str.toString();
	}

	public static void main(String[] args) {
		System.out.println(longestDiverseString(7, 1, 0));
	}
}
