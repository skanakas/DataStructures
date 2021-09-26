package com.srk.strings;

public class CountOfPalindromicSubString {

	public static void main(String[] args) {
		String s = "abdbca";
		
		char[] c = s.toCharArray();
		int count = 0;
		
		for(int i = 0; i<c.length; i++) {
			count+= palindromLen(c, i, i);
			count+= palindromLen(c,i,i+1);
		}
		
		System.out.println(count);
		
	}

	private static int palindromLen(char[] c, int s, int e) {
		int count = 0;
		while(s>=0 && e<c.length && c[s--] == c[e++]) {
			count++;
		}
		
		return count;
	}

}
