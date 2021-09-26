package com.srk.arrays;

import java.util.PriorityQueue;

public class MaxTheifCanBeCaught {

	public static void main(String[] args) {
		int k;

		char policeTheifArray[] = {'P', 'T', 'T', 'P', 'T'};
		k = 2;

		System.out.println("Maximum thieves caught for {P, T, T, P, T}: " + policeThief(policeTheifArray,k)); 

		char policeTheifArray1[] = {'T', 'T', 'P', 'P', 'T', 'P'};
		k = 2;

		System.out.println("Maximum thieves caught for {T, T, P, P, T, P}: " + policeThief(policeTheifArray1, k)); 

	}

	public static int policeThief(char[] arr, int k) { 

		PriorityQueue<Integer> minT = new PriorityQueue<Integer>((a,b)->a-b);
		PriorityQueue<Integer> minP = new PriorityQueue<Integer>((a,b)->a-b);

		for(int i=0; i<arr.length; i++){
			if(arr[i] == 'P')
				minP.offer(i);
			else
				minT.offer(i);
		}
		int result = 0;
		while(!minT.isEmpty() && !minP.isEmpty()){
			if(Math.abs(minT.peek() - minP.peek()) <=k){
				result++;
				minT.poll(); minP.poll();
			} else if (minT.peek() < minP.peek())
				minT.poll();
			else
				minP.poll();
		}

		return result;  

	}
}