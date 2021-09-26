package com.srk.heap;

import java.util.PriorityQueue;

public class MinPlatformsForTrain {

	public static void main(String[] args) {
		System.out.println(
				findPlatform(
						new int[] {900, 940, 950, 1100, 1500, 1800},
						new int[] {910, 1200, 1120, 1130, 1900, 2000}
						)
				);
	}


	public static int findPlatform(int[] arrival, int[] departure) {
		PriorityQueue<Integer> endMinQ = new PriorityQueue<Integer>((a,b)->a-b);
		
		for(int i = 0; i<arrival.length; i++) {
			
			if(!endMinQ.isEmpty() && endMinQ.peek() <= arrival[i])
				endMinQ.poll();
			
			endMinQ.offer(departure[i]);
		}
		
		return endMinQ.size();

	}

}
