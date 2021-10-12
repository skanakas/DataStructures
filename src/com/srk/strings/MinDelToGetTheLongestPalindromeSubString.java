package com.srk.strings;

import java.util.Arrays;

public class MinDelToGetTheLongestPalindromeSubString {

	public static void main(String[] args) {
		
		System.out.println(MinDelToGetTheLongestPalindromeSubString.findMinimumDeletions("cdedp"));
		
	}

	private static int findMinimumDeletions(String s) { 
		return s.length() - longest(s);
	}

	private static int longest(String s) {
		
		int[][] dp = new int[s.length()][s.length()];
		
		for(int i = 0; i<s.length(); i++) {
			dp[i][i] = 1;
		}
		
		for(int start = s.length()-1; start>=0; start --) {
			for(int end=start+1; end<s.length(); end++) {
				
				if(s.charAt(start) == s.charAt(end)) {
					dp[start][end] = 2+dp[start+1][end-1];
				} else {
					dp[start][end] = Math.max(dp[start+1][end], dp[start][end-1]);
				}
			}
		}
		
		for(int d[] : dp) {
			System.out.println(Arrays.toString(d));
		}
		
		return dp[0][s.length()-1];
	}

}
