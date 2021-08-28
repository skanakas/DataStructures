package com.srk.twopointers;

public class RemoveDuplicate {

	public static void main(String[] args) {
		int arr[] = {1,1,2,2,2,4,4,5,6,7,7,7,7,9,10,10,21};
		int nextNonDuplicate = 1;
		for(int i = 1; i<arr.length; i++) {
			if(arr[nextNonDuplicate-1] != arr[i]) {
				arr[nextNonDuplicate] = arr[i];
				nextNonDuplicate++;
			}
		}
		printArray(arr);
	}
	
	public static void printArray(int arr[]) {
		for(int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
}
