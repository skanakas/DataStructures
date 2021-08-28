package com.srk.arrays;

public class MaxProfitInStockList {

	public static void main(String[] args) {
		//sellOnce();
		int arr[] = {12,11,13,9,12,8,14,13,15};
		
		int fs = Integer.MIN_VALUE, ss = Integer.MIN_VALUE;
		int fb = 0, sb = 0;
		
		for(int i=0; i<arr.length-1; i++) {
			fb = Math.max(fb, -arr[i]);
			fs = Math.max(fs, fb+arr[i]);
			sb = Math.max(sb, fs-arr[i]);
			ss = Math.max(ss, sb+arr[i]);
		}
		
		System.out.println(ss);
	}

	private static void sellOnce() {
		int arr[] = {7,1,4,7,6,3};
		
		int min = Integer.MAX_VALUE;
		int maxProfit = 0;
		
		for(int i = 0; i<arr.length-1; i++) {
			if(arr[i] < min)
				min = arr[i];
			else if(arr[i]-min>maxProfit) {
				maxProfit = arr[i]-min;
			}
		}
		System.out.println(maxProfit);
	}

}
