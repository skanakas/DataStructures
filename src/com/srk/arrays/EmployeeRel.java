package com.srk.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeRel {
	
	private static Map<Character, Integer> countMap = new HashMap<>();

	public static void main(String[] args) {
		char[][] data = {{'A','C'},{'B','C'},{'C','F'},{'D','E'},{'E','F'},{'A','B'},{'D','B'}};
		
		Map<Character, List<Character>> map = new HashMap<>();
		
		
		for(int i=0; i<data.length; i++) {
			Character manager = data[i][1];
			Character emp = data[i][0];
			
			if(map.containsKey(manager)) {
				map.get(manager).add(emp);
			} else {
				map.put(manager, new ArrayList<>(Arrays.asList(emp)));
			}
		}
		
		for(Character mgr: map.keySet()) {
			countMap.put(mgr, count(mgr, map));
		}
		
		System.out.println(countMap);
		
	}
	
	public static int count(Character mgr, Map<Character, List<Character>> map) {
		
		if(!map.containsKey(mgr)) {
			countMap.put(mgr, 0); //Missed this part
			return 0;
		}
		
		int count = 0;
		
		if(countMap.containsKey(mgr)) {
			return countMap.get(mgr);
		}
		
		List<Character> emps = map.get(mgr);
		for(Character e: emps) {
			count++;
			count += count(e,map);
		}
		return count;
		
	}

}
