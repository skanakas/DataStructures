package com.srk.twopointers;

public class DutchNationalFlag {

	public static void main(String[] args) {
		int[] arr = {1,0,1,0,1,2,2,1,0};
		
		int l = 0;
		int r = arr.length-1;
		
		int i = 0;
		while(i<r) {
			if(arr[i] == 0) {
				int temp = arr[i];
				arr[i] = arr[l];
				arr[l] = temp;
				
				l++;
				i++;
			} else if(arr[i] == 1) {
				i++;
			} else {
				int temp = arr[i];
				arr[i] = arr[r];
				arr[r] = temp;
				
				r--;
			}
		}
		
		for(int x : arr) {
			System.out.print(x+" ");
		}
	}

}
