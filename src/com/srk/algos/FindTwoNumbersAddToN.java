package com.srk.algos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindTwoNumbersAddToN {
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,6,8,4,3,6,4,3};
		int N = 11;
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int num : arr) {
			if(map.containsKey(N-num)) {
				System.out.println(Arrays.toString(new int[] {num, map.get(N-num)}));
				break;
			}
			map.put(num, num);
		}
		System.out.println(new int[] {0,0});
	}
	
	

}
