package com.srk.booking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LargestHotelGroup {
	private static int[][] topKHotels(Integer[][] data, int K){

		Map<Integer, Integer> hotelCount = new HashMap<>();
		Map<Integer, Integer> childToParentMap = new HashMap<>();

		for(Integer[] d : data) {
			Integer child = d[0];
			Integer parent = d[1];
			Integer count = d[2];

			childToParentMap.put(child, parent);
			hotelCount.putIfAbsent(child, 0);
			hotelCount.put(child, hotelCount.get(child)+count);
		}

		Set<Integer> visited = new HashSet<>();        
		for(Map.Entry<Integer, Integer> entry : childToParentMap.entrySet()){
			Integer node = entry.getKey();
			Integer count = entry.getValue();
			boolean isVisited = visited.contains(node);
			while(node != null && !isVisited) {
				visited.add(node);
				Integer cCount = hotelCount.get(node);
				Integer p = childToParentMap.get(node);
				if(p != null) {
					hotelCount.put(p, hotelCount.get(p)+cCount);
				}
				node = p;
			}
		}
		System.out.println(hotelCount);   

		return null;
	}

	public static void main(String[] args) {

		Integer[][] A = new Integer[][]{
			{ 3,0,14},
			{0, null, 10},
			{4,0,44},
			{6, null, 7},
			{10, 6, 13},
			{7, 6, 17},
			{2, null, 2},
			{14, 2, 9},
			{25, 14, 10},
			{12, 2, 10},
			{13, 0, 1},
			{14, 2, 9},
		};
		int K = 2;
		topKHotels(A,2);
	}
}
