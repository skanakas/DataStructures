package com.srk.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationInAString {

	public static void main(String[] args) {
		/*System.out.println(permutationInAString("oidbcaf", "abc"));
		System.out.println(permutationInAString("odicf", "dc"));
		System.out.println(permutationInAString("bcdxabcdy", "bcdyabcdx"));
		System.out.println(permutationInAString("aaacb", "abc"));*/
		
		//System.out.println(anagramsIndexes("abbcabc", "abc"));
		
		System.out.println(smallestSubStringContainingPattern("babeaebcaae", "aabc"));
	}

	private static String smallestSubStringContainingPattern(String str, String pattern) {
		
		String subStr = "";
		
		Map<Character, Integer> pMap = toMap(pattern);
		
		int matched = 0, windowStart = 0, minLength = Integer.MAX_VALUE, subStringStart = 0;
		for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			
			char right = str.charAt(windowEnd);
			char left = str.charAt(windowStart);
			
			if(pMap.containsKey(right)) {
				pMap.put(right, pMap.get(right)-1);
				if(pMap.get(right) >= 0) 
					matched++;
			}
			
			while(matched == pattern.length()) {
				
				if(minLength > windowEnd - windowStart + 1) {
					minLength = windowEnd - windowStart + 1;
					subStringStart = windowStart;
				}
				
				windowStart++;
				if(pMap.containsKey(left)) {
					if(pMap.get(left) == 0) 
						matched --;
					pMap.put(left, pMap.get(left)+1);
				}
				
			}
			
		}
		
		return str.substring(subStringStart, subStringStart+minLength);
		
	}

	private static boolean permutationInAString(String string, String pattern) {

		Map<Character, Integer> patternMap = toMap(pattern);

		int windowStart = 0;
		for(int windowEnd = 0; windowEnd < string.length(); windowEnd++) {

			Character right = string.charAt(windowEnd);

			if(patternMap.size() > 0 && patternMap.containsKey(right)) {
				patternMap.put(right, patternMap.get(right)-1);
				if(patternMap.get(right) == 0) {
					patternMap.remove(right);
				}

				if(patternMap.isEmpty()) return true;
			} else if (windowEnd-windowStart+1 > pattern.length()){
				patternMap = toMap(pattern);
				windowStart++;
			}

		}

		return false;
	}

	private static int[] anagramsIndexes(String string, String pattern) {

		Map<Character, Integer> patternMap = toMap(pattern);

		int[] output = new int[string.length()];
		int count = 0;
		
		int windowStart = 0, matched = 0;
		for(int windowEnd = 0; windowEnd < string.length(); windowEnd++) {
			char right = string.charAt(windowEnd);
			char left = string.charAt(windowStart);
			
			if(patternMap.containsKey(right)) {
				patternMap.put(right, patternMap.get(right)-1);
				if(patternMap.get(right) == 0)
					matched++;
			}
			
			if(matched == patternMap.keySet().size()) {
				output[count++] = windowStart; 
				System.out.println(windowStart);
			}
				
			if(windowEnd >= pattern.length() -1) {
				if(patternMap.containsKey(left)) {
					if(patternMap.get(left) == 0)
						matched --;
					patternMap.put(left, patternMap.get(left) +1);
				}
				windowStart++;
			}
			
		}

		return output;
	}

	private static Map<Character, Integer> toMap(String pattern) {
		Map<Character, Integer> map = new HashMap<>();
		for(Character c : pattern.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		return map;
	}

}
