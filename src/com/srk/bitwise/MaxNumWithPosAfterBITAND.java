package com.srk.bitwise;

public class MaxNumWithPosAfterBITAND {

	public static void main(String[] args) {
		int N = 100;
		int n = bitsCount(N);
		
		System.out.println(
				Math.max(N-Math.pow(2, n-1)+1, 				//(N - 2^n +1)
				Math.pow(2, n-1)-Math.pow(2, n-2))); 	// 2^n-1 - 2^n-2
		
	}
	private static int bitsCount(int n) {
		int ans = 0;
		while(n>0) {
			ans++;
			n = n>>1;
		}
		return ans;
	}
	
}
