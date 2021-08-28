package com.srk.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class NoRepeatingSubString {

	public static void main(String[] args) {
		String str = args[0];
		
		if(str == null || str.length()==0)
			throw new IllegalArgumentException();
		
		Set<Character> set = new HashSet<>();
		
		int windowStart = 0; int max = 0;
		for(int windowEnd=0; windowEnd<str.length(); windowEnd++) {
			
			Character charAT = str.charAt(windowEnd);
			if(set.contains(charAT)) {
				max = Math.max(max, windowEnd-windowStart);
				windowStart++;
			} else {
				set.add(charAT);
			}
		}
		
		System.out.println(max);
	}

}
