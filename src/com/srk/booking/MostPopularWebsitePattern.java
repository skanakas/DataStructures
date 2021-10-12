package com.srk.booking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class LOG{
	public Integer user;
	public Character page;
	public Integer getUser() {
		return user;
	}
	public void setUser(Integer user) {
		this.user = user;
	}
	public Character getPage() {
		return page;
	}
	public void setPage(Character page) {
		this.page = page;
	}
}

public class MostPopularWebsitePattern {

	private static List<String> getMostPopularPatternOfLenK(char[][] logs, int size){
		List<String> result = new ArrayList<>();

		Map<Integer, ArrayList<Character>> userToWebSiteMap = new HashMap<>();
		for(char[] log : logs) { //O(N)
			Integer userID = Integer.parseInt(log[0]+"");
			userToWebSiteMap.putIfAbsent(userID, new ArrayList<>());
			userToWebSiteMap.get(userID).add(log[1]);
		}
		System.out.println(userToWebSiteMap);

		Map<String, Integer> patternCount = new HashMap<>();
		for(Integer uid : userToWebSiteMap.keySet()) {
			List<Character> visits = userToWebSiteMap.get(uid);

			if(visits.size()>=size) {
				HashSet<String> patterns = new HashSet<>();
				for(int i = 0; i<visits.size()-2; i++) {
					for(int j = i+1; j<visits.size()-1; j++) {
						for(int k = j+1; k<visits.size(); k++) {
							StringBuilder pattern = new StringBuilder();
							pattern
								.append(visits.get(i))
								.append(" ")
								.append(visits.get(j))
								.append(" ")
								.append(visits.get(k));
							patterns.add(pattern.toString());
						}
					}
				}
				
				for(String s : patterns) {
					patternCount.put(s, patternCount.getOrDefault(s, 0)+1);
				}
			}
		}
		
		System.out.println(patternCount);
		List<Map.Entry<String, Integer>> ll = new LinkedList<>(patternCount.entrySet());
		Collections.sort(ll, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o2.getValue()-o1.getValue();
			}
		});
		System.out.println(ll);
		
		return Arrays.asList(ll.get(0).getKey().split(" "));
	}

	public static void main(String[] args) {
		char[][] logs = new char[][] {
			{'1','A'},
			{'2','B'},
			{'1','B'},
			{'1','D'},
			{'2','A'},
			{'3','B'},
			{'3','D'},
			{'1','C'},
			{'3','C'},
			{'2','C'},
			{'3','B'},
			{'1','A'},
			{'3','C'},
		};

		List<String> mostPopularPatternOfLenK = getMostPopularPatternOfLenK(logs, 3);
		System.out.println(mostPopularPatternOfLenK);
	}


}
