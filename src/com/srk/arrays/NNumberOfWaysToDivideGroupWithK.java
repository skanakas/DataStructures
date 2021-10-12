package com.srk.arrays;

/**
 * 	Input: N = 8, K = 4 
		Output: 5 
		Explanation: 
		Their are 5 groups such that their sum is 8 and the number of positive integers in each group is 4. 
		[1, 1, 1, 5], [1, 1, 2, 4], [1, 1, 3, 3], [1, 2, 2, 3], [2, 2, 2, 2]
		Input: N = 24, K = 5 
		Output: 164 
		Explanation: 
		There are 164 such groups such that their sum is 24 and number of positive integers in each group is 5
 * @author arun
 *
 */


public class NNumberOfWaysToDivideGroupWithK {

	public static void main(String[] args) {
		System.out.println(calculate(8,4));
		System.out.println(calculate(24,5));
	}

	private static int calculate(int N, int K) {
		return calculate(0,1,N,K);
	}

	private static int calculate(int index, int minVal, int balance, int K) {

		if (index == K)
		{
			if (balance == 0)
				return 1;
			else
				return 0;
		}

		if (minVal == 0)
			return 0;

		int result = 0;

		for(int i = minVal; i<=balance; i++) {
			result += calculate(index+1, i, balance-i,K);
		}


		return result;
	}
}
