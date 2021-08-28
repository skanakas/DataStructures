package com.srk.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrippletsLessThanTheTarget {

	public static void main(String[] args) {
		int[] arr = {-1,4,2,1,3};
		int targetSum = 5;
		
		Arrays.sort(arr);
		
		for(int i : arr) {
			System.out.print(i+" ");
		}
		
		List<List<Integer>> tripplets = new ArrayList<>();

		for(int i = 0; i<arr.length-2; i++) {
			
			if(i>0 && arr[i]==arr[i-1]) continue;
			
			int start = arr[i];
			int left = i+1;
			int right = arr.length-1;
			
			while(left<right) {
				int checkSum = start+arr[left]+arr[right];
				
				if(checkSum < targetSum) {
					int end = right;
					while(left<end)
						tripplets.add(Arrays.asList(start,arr[left],arr[end--]));
					
					left++;
				} else {
					right--;
				}
			}
		}
		System.out.println("\nOP: tripplets="+tripplets);
	}

}
