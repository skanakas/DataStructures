package com.srk.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CombineSimilarMessages {

	public static void main(String[] args) {
		String[] messages = {"lmn", "mno", "azb", "bac", "yza", "bdfg"};
		List<List<String>> groups = combineMessages(messages);
		System.out.println(groups);
	}

	private static List<List<String>> combineMessages(String[] messages) {
		Map<String, List<String>> groupMap = new HashMap<>();
		for(String s : messages) {
			String key = generateKey(s);
			groupMap.putIfAbsent(key, new ArrayList<>());
			groupMap.get(key).add(s);
		}
		
		return groupMap.values().stream().collect(Collectors.toList());
	}

	private static String generateKey(String word) {
		
		char[] c = word.toCharArray();
		String key = "";
		
		for(int i = 1; i<c.length; i++) {
			int diff = c[i]-c[i-1];
			
			key+= (diff <0) ? diff+26 : diff;
			key+=",";
		}
		
		return key;
	}

}
