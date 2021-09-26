package com.srk.strings;

public class MaxDeletionToMakeAPalindromSubSeq {

	public static void main(String[] args) {
		
		String str = "pqrwes";
		char[] c = str.toCharArray();
		
		Integer[][] dp = new Integer[str.length()][str.length()];
		
		int longestSubSeq = getResult(c, dp, 0, c.length-1);
		
		int numOfDel = c.length - longestSubSeq;
		
		System.out.println(numOfDel);
		
	}

	private static int getResult(char[] c, Integer[][] dp, int s, int e) {
		
		if(c.length == 0) return 0;
		
		if(s>=e) return 1;
		
		if(dp[s][e] == null) {
			
			if(c[s] == c[e]) {
				dp[s][e] = 2 + getResult(c, dp, s+1, e-1);
			} else {
				int l1 = getResult(c, dp, s+1, e);
				int l2 = getResult(c, dp, s, e-1);
				dp[s][e] = Math.max(l1, l2);
			}
			
		}
		
		return dp[s][e];
	}

}
