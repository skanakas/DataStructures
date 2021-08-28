package com.srk.slidingwindow;

public class AvgOfSubArrayOfSizeK {

	public static void main(String[] args) {
		
		int arr[] = {1,3,5,-1,-3,5,10,4,9,20,6,-7};
		int K = 5;
		int result[] = new int[arr.length - K+1];
		
		int windowStart = 0;
		int windowSum = 0;
		for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			windowSum += arr[windowEnd];
			if((windowEnd - windowStart) == K-1) {
				result[windowStart] = windowSum/K;
				windowSum -= arr[windowStart];
				windowStart++;
			}
		}
		
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i]+" ");
		}
		
		
	}

}
