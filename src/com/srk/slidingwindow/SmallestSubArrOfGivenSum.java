package com.srk.slidingwindow;

public class SmallestSubArrOfGivenSum {

	public static void main(String[] args) {
		int arr[] = {2,1,5,2,3,2};
		int S = 7;
		
		int windowStart = 0;
		int minSize = Integer.MAX_VALUE;
		int windowSum = 0;
		
		for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			windowSum += arr[windowEnd];
			
			while(windowSum >= S) {
				if(windowSum == S) {
					int windowSize = windowEnd - windowStart+1;
					minSize = Math.min(minSize, windowSize);
				}
				windowSum -= arr[windowStart++];
			}
		}
		System.out.println(minSize);
	}

}
