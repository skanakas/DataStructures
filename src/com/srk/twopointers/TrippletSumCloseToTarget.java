package com.srk.twopointers;

import java.util.Arrays;

public class TrippletSumCloseToTarget {

	public static void main(String[] args) {
		int arr[] = {-2,0,1,2};
		int targetSum = 2; 
		System.out.println(maxSum(arr, targetSum));

	}

	private static int maxSum(int[] arr, int targetSum) {
		int minDifference = Integer.MAX_VALUE;
		int maxSum = 0;
		
		Arrays.sort(arr);
		
		for(int i=0; i<arr.length-2; i++) {
			
			if(i>0 && arr[i-1] == arr[i]) continue;
			
			int first = i;
			int left = i+1;
			int right = arr.length-1;
			
			while(left<right) {
				int checkSum = arr[first]+arr[left]+arr[right];
				
				if(checkSum == targetSum)
					return checkSum;
				
				if(checkSum<targetSum)
					left++;
				else
					right--;
				
				if(Math.abs(targetSum-checkSum) < minDifference)
				{
					maxSum = checkSum;
					minDifference = Math.abs(targetSum-checkSum);
				}
			}
		}
		return maxSum;
	}

}
