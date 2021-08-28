package com.srk.twopointers;

public class RemoveDuplicatesMoreThanNTimesTo2Times {

	public static void main(String[] args) {
		int arr[] = {1,1,2,2,7,7,4,4,5,6,7,7,7,7,9,10,10,21};
		
		int key = 7;
		int maxDuplicate = 2;
		int currentDup = 0;
		
		int nextNonKeyIndex = -1;
		for(int i = 0; i<arr.length; i++) {		
			if(arr[i] != key) {
				nextNonKeyIndex++;
				arr[nextNonKeyIndex] = arr[i];
			} else if(currentDup <= maxDuplicate) {
				nextNonKeyIndex++; currentDup++;
				arr[nextNonKeyIndex] = arr[i];
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
