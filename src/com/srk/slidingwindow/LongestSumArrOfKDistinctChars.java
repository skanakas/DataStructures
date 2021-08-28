package com.srk.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSumArrOfKDistinctChars {

	public static void main(String[] args) {
		Map<Character, Integer> map = new HashMap<>();
		
		char arr[] = {'c','b','b','e','b', 'i'};
		int K = 3;
		
		int windowStart = 0, maxArraSize = 0;
		
		for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			
			map.put(arr[windowEnd], map.getOrDefault(arr[windowEnd], 0)+1);
			
			if(map.keySet().size() > K) {
				map.put(arr[windowStart], map.get(arr[windowStart])-1);
				if(map.get(arr[windowStart]) == 0)
					map.remove(arr[windowStart]);
				windowStart++;
			} else if(map.keySet().size() == K) {
				maxArraSize = Math.max(maxArraSize, windowEnd - windowStart+1);
			}
			System.out.println(map);
		}
		
		System.out.println(maxArraSize);
		
	}

}
