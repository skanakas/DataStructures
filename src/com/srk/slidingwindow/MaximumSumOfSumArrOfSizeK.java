package com.srk.slidingwindow;

public class MaximumSumOfSumArrOfSizeK {

	public static void main(String[] args) {
		int arr[] = {1,2,3,5,6,7,8,4,3,2,3,4,5,7,8};
		int maxSum = 0;
		int K = 5;
		int sums[] = new int[arr.length - K +1];
		
		int windowStart = 0;
		int windowSum = 0;
		
		for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			windowSum += arr[windowEnd];
			
			if(windowEnd - windowStart >= K-1) {
				sums[windowStart] = windowSum;
				maxSum = Math.max(maxSum, windowSum);
				windowSum -= arr[windowStart++];
			}
		}
		System.out.print("{");
		for(int i = 0; i < sums.length; i++) {
			System.out.print(sums[i]+" ");
		}
		System.out.println("}");
		System.out.println("MAX SUM = "+maxSum);
	}

}
