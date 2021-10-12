package com.srk.booking;

import java.util.Arrays;

public class MinimumCarRoofLength {
	
	private static int getSolution(int[] arr, int k) {
		int MIN = Integer.MAX_VALUE;
		
		if(arr == null || arr.length == 0 || k ==0)
			return 0;
			
		if(k>arr.length)
			return MIN;
		
		Arrays.sort(arr); //SORT
		
		int start = 0;
		int end = 0;
		while(end<arr.length) {
			if(end-start+1 == k) {
				MIN = Math.min(MIN, arr[end]-arr[start]+1);
				start++;
			}
			end++;
		}
		
		
		return MIN;
	}
	
	public static void main(String[] args) {
		System.out.println(getSolution(new int[] {12, 6, 5, 2, 9}, 4));
	}

}
