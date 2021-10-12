package com.srk.booking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 
 *
 */
public class MostPopularKLenSequence {

	public static List<String> mostVisitedPattern(String[] userName, int[] timestamp, String[] website) {

		HashMap<String, ArrayList<WebsiteWithTime>> userMap = new HashMap<>();
		//create a map with username as the key and a list of websites with timestamps
		for(int i = 0; i < userName.length; i++){
			String user = userName[i];
			WebsiteWithTime websiteDetail = new WebsiteWithTime(website[i], timestamp[i]);
			ArrayList<WebsiteWithTime> websites = userMap.getOrDefault(user, new ArrayList<WebsiteWithTime>());
			websites.add(websiteDetail);
			userMap.put(user, websites);
		}


		HashMap<String, Integer> patternCount = new HashMap<>();
		for(String key : userMap.keySet()){
			ArrayList<WebsiteWithTime> websites = userMap.get(key);
			if(websites.size() > 2) {
				Collections.sort(websites, (a,b) ->{return a.timeStamp - b.timeStamp;});
				HashSet<String> patterns = new HashSet<>();
				for(int i = 0; i < websites.size()-2; i++){
					for(int j = i+1; j < websites.size() - 1; j++){
						for(int k = j+1; k < websites.size(); k++){

							StringBuilder patternKey = new StringBuilder();
							patternKey.append(websites.get(i).website);
							patternKey.append(" ");
							patternKey.append(websites.get(j).website);
							patternKey.append(" ");
							patternKey.append(websites.get(k).website);
							patterns.add(patternKey.toString());
						}
					}
				}
				for(String pattern : patterns){
					patternCount.put(pattern, patternCount.getOrDefault(pattern,0)+1);
				}
			}
		}
		/**
		 * Sort in decending order
		 */
		ArrayList<String> patterns = new ArrayList<>(patternCount.keySet());
		Collections.sort(patterns, (a,b) -> {
			if (patternCount.get(a) == patternCount.get(b)){
				return a.compareTo(b);                                     
			} else {
				return patternCount.get(b) - patternCount.get(a);
			}
		});

		String largestPattern = patterns.get(0);
		ArrayList<String> result = new ArrayList<>();
		String[] tokens = largestPattern.split(" ");
		return Arrays.asList(tokens);
	}

	//inner class to keep website with time
	static class WebsiteWithTime{
		String website;
		int timeStamp;

		WebsiteWithTime(String website, int time){
			this.website = website;
			this.timeStamp = time;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(mostVisitedPattern(
				new String[] {"joe","joe","joe","james","james","james","james","mary","mary","mary"},
				new int[] {1,2,3,4,5,6,7,8,9,10},
				new String[] {"home","about","career","home","cart","maps","home","home","about","career"}
				));
	}

}
