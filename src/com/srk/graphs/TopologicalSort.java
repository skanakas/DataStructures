package com.srk.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public class TopologicalSort {

	public static void main(String[] args) {
		List<Integer> result = TopologicalSort.sort(4,
				new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
		System.out.println(result);

		result = TopologicalSort.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
			new int[] { 2, 1 }, new int[] { 3, 1 } });
		System.out.println(result);

		result = TopologicalSort.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
			new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
		System.out.println(result);
	}

	private static List<Integer> sort(int vertices, int[][] edges) {
		
		List<Integer> sortedList = new ArrayList<>();
		if(vertices<=0)
			return sortedList;
		
		Map<Integer, Integer> in = new HashMap<>();
		Map<Integer, List<Integer>> graph = new HashMap<>();
		
		/**
		 * Having place holders for vertices
		 */
		for(int i = 0; i<vertices; i++) {
			in.put(i, 0);
			graph.put(i, new ArrayList<>());
		}
		
		/**
		 * Add edges
		 */
		for(int i = 0; i<edges.length; i++) {
			int src = edges[i][0], end = edges[i][1];
			graph.get(src).add(end);
			in.put(end, in.getOrDefault(end, 0)+1);
		}
		
		Queue<Integer> sources = new LinkedList<>();
		for(Entry<Integer, Integer> entry : in.entrySet()) {
			if(entry.getValue()==0) {
				sources.offer(entry.getKey());
			}
		}
		
		while(!sources.isEmpty()) {
			
			Integer source = sources.poll();
			sortedList.add(source);
			
			List<Integer> outs = graph.get(source);
			for(Integer out : outs) {
				in.put(out, in.get(out)-1);
				
				if(in.get(out) == 0) {
					sources.offer(out);
				}
			}
		}
		
		if(sortedList.size() != vertices)
			return Collections.emptyList();
		
		return sortedList;
	}

}
