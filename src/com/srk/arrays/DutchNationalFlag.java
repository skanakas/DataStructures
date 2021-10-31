package com.srk.arrays;

import java.util.Arrays;

public class DutchNationalFlag {

	public static void main(String[] args) {
		
		int[] arr = new int[]{2, 0, 0, 1, 2, 1, 0};
		
		int left = 0;
		int mid = 0;
		int right = arr.length-1;
		
		while(mid<=right) {
			if(arr[mid]==0) {
				swap(arr, left++, mid++);
			} else if(arr[mid] == 2){
				swap(arr, mid, right--);
			} else {
				mid++;
			}
		}
		
		System.out.println(left+" "+mid+" "+right);
		
		System.out.println(Arrays.toString(arr));
		
	}

	private static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

}
