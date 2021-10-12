package com.srk.arrays;

public class MinDeletionAlmostSorted {

	public static void main(String[] args) {
		int[] arr = new int[] {3,4,2,5,1};
		
		int prev = 0;
		int dips = 0;
		for(int curr = 1; curr<arr.length; curr++) {
			
			if(arr[curr]>arr[prev]) {
				prev++;
			} else {
				dips++;
			}
			
		}
		
		System.out.println((dips>1)?dips-1:0);
	}

}
