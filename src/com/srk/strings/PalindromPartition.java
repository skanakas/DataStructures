package com.srk.strings;

import java.util.HashMap;
import java.util.Map;

public class PalindromPartition {

	public static void main(String[] args) {
		
		String str = "cdpddd";
		Map<Integer, Integer> partitions = new HashMap<>();
		
		char c[] = str.toCharArray();
		
		Integer preEnd = 0;
		
		for(int i = 0; i< c.length; i++) {
			
			if(i>0 && preEnd>=i)
				continue;
			
			int maxL = isPalindrome(c, i, i);
			//int l2 = isPalindrome(c, i, i+1);
			
			//int maxL = Math.max(l1, l2);
			if(maxL>0) {
				int s = i - ((maxL-1)/2);
				int e = (maxL/2) + i;
				preEnd = e;
				
				System.out.println("Palindrom S="+s+"|E="+e+"|Str="+str.substring(s,e+1));
				partitions.put(s, e);
			}
		}
		
		System.out.println("Answer = "+(partitions.size()-1));
	}
	
	private static int isPalindrome(char[] c, int s, int e) {
		while(s>=0 && e<c.length && c[s] == c[e]) {
			s--; e++;
		}
		return e - s - 1;
	}

}
