package com.srk.twopointers;

public class SquaringASortedArray {

	public static void main(String[] args) {
		int[] arr = {-2,-1,0,1,2,3};
		int[] r = new int[arr.length];
		
		int left=0,right=arr.length-1;
		
		int high = arr.length-1;
		while(left<right) {
			int leftSquare = arr[left]*arr[left];
			int rightSquare = arr[right]*arr[right];
			
			if(leftSquare>rightSquare) {
				r[high--]=leftSquare;
				left++;
			} else {
				r[high--]=rightSquare;
				right--;
			}
		}
		
		for(int i : r) {
			System.out.print(i+" ");
		}
		
	}

}
