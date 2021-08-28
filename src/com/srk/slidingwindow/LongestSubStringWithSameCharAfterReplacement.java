package com.srk.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithSameCharAfterReplacement {

	public static void main(String[] args) {
		/**
		 * Variation 1
		 */
		longSeqOfCharsAfterReplacementOfKChars();
		
		
		/**
		 * Variation 2
		 */
		longSequenceOfOnesAfterKZeroReplacement();
	}

	private static void longSequenceOfOnesAfterKZeroReplacement() {
		int arr[] = {0,1,0,0,1,1,0,1,1,0,0,1,1};
		int K = 3;
		int windowStart = 0, maxCharArraySize = 0, max1sInWindow = 0;
		int repTracter[] = new int[2];
		
		for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			if(arr[windowEnd] == 0) {
				repTracter[0]++;
			} else {
				repTracter[1]++;
			}
			max1sInWindow = repTracter[1];
			
			if(windowEnd-windowStart+1 - max1sInWindow > K) {
				repTracter[arr[windowStart++]]--;
			}
			maxCharArraySize = Math.max(windowEnd-windowStart+1, maxCharArraySize);
		}
		System.out.println("longSequenceOfOnesAfterKZeroReplacement="+maxCharArraySize);
	}

	private static void longSeqOfCharsAfterReplacementOfKChars() {
		
		String str = "aabbcb";
		int K = 1;

		int windowStart = 0, maxCharArraySize = 0, maxRepeatingChars = 0;
		Map<Character, Integer> map = new HashMap<>();

		for(int windowEnd = 0; windowEnd<str.length(); windowEnd++) {
			map.put(str.charAt(windowEnd), map.getOrDefault(str.charAt(windowEnd), 0)+1);
			maxRepeatingChars = Math.max(map.get(str.charAt(windowEnd)), maxRepeatingChars);
			
			if(windowEnd-windowStart+1 - maxRepeatingChars > K) {
				map.put(str.charAt(windowStart), map.get(str.charAt(windowStart))-1);
				windowStart++;
			}
			
			maxCharArraySize = Math.max(maxCharArraySize, windowEnd-windowStart+1);
		}
		
		System.out.println("longSeqOfCharsAfterReplacementOfKChars="+maxCharArraySize);
	}

}
