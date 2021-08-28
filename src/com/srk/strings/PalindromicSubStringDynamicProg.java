package com.srk.strings;

import java.util.ArrayList;
import java.util.List;

public class PalindromicSubStringDynamicProg {

	private static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		String str = "abbab";

		countSubStringProblems(str);

		partitionProblems(str);
	}
	


	private static void partitionProblems(String str) {
		int len = str.length();
		boolean[][] dp = new boolean[len][len];
		List<List<String>> possiblePartitions = new ArrayList<>();
		dfs(0,str,dp,possiblePartitions, new ArrayList<String>());
		System.out.println(possiblePartitions);
	}

	private static void dfs(int start, String str, boolean[][] dp, List<List<String>> possiblePartitions, ArrayList<String> currPart) {
		
		if(start>=str.length())  possiblePartitions.add(new ArrayList<>(currPart));
		
		for(int end = start; end<str.length(); end++) {
			
			if(str.charAt(start) == str.charAt(end) && (end-start<=2 || dp[start+1][end-1])) {
				dp[start][end] = true;
				currPart.add(str.substring(start, end+1));
				
				dfs(end+1,str,dp,possiblePartitions,currPart);
				
				currPart.remove(currPart.size()-1);
			}
			
		}
		
	}

	private static void countSubStringProblems(String str) {
		int n = str.length();
		char[] c = str.toCharArray();
		List<String> ll = new ArrayList<>();
		boolean[][] dp = new boolean[str.length()][str.length()];
		int max = 0;
		
		int start = str.length() -1;
		for(int i=start; i>=0; i--) {
			for(int j=i; j<str.length(); j++) {
				
				if(c[i]==c[j] && ((j-i)<=2 || (dp[i+1][j-1]))){
					dp[i][j] = true;
					ll.add(str.substring(i,j+1));
					max = Math.max(max, j-i+1);
				}
				
			}
		}
		System.out.println("All Possible palindromSubStrings = "+ll);
		System.out.println("Length of longest palindrom sub string = "+max);
		System.out.println("COunt of all palindrom sub strings = "+ll.size());
		
		System.out.println("\nDP table ----");
		for(int i = 0; i < n; i++) {
			System.out.print("[");
			for(int j = 0; j<dp[i].length; j++) {
				
				System.out.print(dp[i][j]+",\t");
				
			}
			System.out.println("]");
		}
	}

}
