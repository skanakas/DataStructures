package com.srk.booking;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TopKHotelsFromStartPoint {

	public static void main(String[] args) {
		char[][] data = new char[][] {
			{'1','1','1','1','A'},
			{'1','1','1','1','1'},
			{'1','1','1','1','1'},
			{'1','C','1','B','1'},
			{'1','1','1','D','1'}
		};

		int[] start = new int[]{0,0};
		
		topKClosestHotels(data, start, 2);
		
	}

	private static Map<Character, Integer> hotelToLenMap = new HashMap<>();
	private static int[][] dirs = new int[][] {{1,0}, {-1,0},{0,1},{0,-1}};
	
	private static Map<Character, Integer> topKClosestHotels(char[][] data, int[] start, int K){

		hotelToLenMap.clear();

		find(data, start[0], start[1], 0);
		
		System.out.println(hotelToLenMap);
		
		List<Map.Entry<Character,Integer>> dataLL = new LinkedList<>(hotelToLenMap.entrySet());
		Collections.sort(dataLL, new Comparator<Map.Entry<Character,Integer>>() {

			@Override
			public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
				if(o1.getValue() != o2.getValue())
					return o1.getValue()-o2.getValue();
				else
					return o1.getKey().compareTo(o2.getKey());
			}

		});
		
		System.out.println(dataLL);

		return hotelToLenMap;
	}

	private static void find(char[][] data, int x, int y, int depth) {

		if(x<0||y<0||x>data.length-1||y>data[0].length-1||data[x][y]=='0') {
			return;
		}
		
		if(data[x][y] != '0' && data[x][y]!='1') {
			Integer steps = hotelToLenMap.get(data[x][y]);
			System.out.println("Before--"+data[x][y]+" "+ steps);
			if(steps == null || steps > depth) {
				hotelToLenMap.put(data[x][y], depth);
			}
			System.out.println("After--"+data[x][y]+" "+ hotelToLenMap.get(data[x][y]));
			return;
		}
		
		data[x][y] = '0';
		
		for(int[] dir : dirs) {
			find(data, x+dir[0], y+dir[1], depth+1);
		}
		
		data[x][y] = '1';

	}

}
