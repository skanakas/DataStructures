package com.srk.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMain {

	public static int bestSumKStar(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> values, int k) {

		Map<Integer, List<Integer>> outBoundGraph = new HashMap<Integer, List<Integer>>();
		for(int i = 0; i<gFrom.size(); i++){
			int from = gFrom.get(i);
			int to = gTo.get(i);
			outBoundGraph.putIfAbsent(from, new ArrayList<>());
			outBoundGraph.get(from).add(to);
		}
		System.out.println(outBoundGraph);
		
		Map<Integer, List<Integer>> inBoundGraph = new HashMap<>();
		for(Map.Entry<Integer, List<Integer>> entry : outBoundGraph.entrySet()) {
			int node = entry.getKey();
			List<Integer> outs = entry.getValue();
			for(Integer i : outs) {
				inBoundGraph.putIfAbsent(i, new ArrayList<>());
				inBoundGraph.get(i).add(node);
			}
		}
		System.out.println(inBoundGraph);
		
		
		System.out.println(values);
		int maxSum = Integer.MIN_VALUE;
		for(Map.Entry<Integer, List<Integer>> entry : outBoundGraph.entrySet()){
			int mainNode = entry.getKey();
			System.out.println(entry);
			if(entry.getValue().size() >=k) {
				List<Integer> child = entry.getValue();
				List<Integer> childVals = new ArrayList<>();
				for(Integer index : child) {
					childVals.add(values.get(index));
				}
				if(inBoundGraph.containsKey(mainNode)) {
					for(Integer index : inBoundGraph.get(mainNode)) {
						childVals.add(values.get(index));
					}
				}
				Collections.sort(childVals);
				System.out.println("mainNode="+mainNode+" childVals="+childVals);
				Integer checkSum = values.get(mainNode);
				int lastK = k;
				int i = childVals.size()-1;
				while(lastK>0 && i>=0) {
					checkSum+=childVals.get(i);
					i--;
					lastK--;
				}
				maxSum = Math.max(maxSum, checkSum);
				
			}
		}
		System.out.println(maxSum);
		return maxSum;
	}

	public static void main(String[] args) {
		//bestSumKStar(7, Arrays.asList(7,0,1,1,3,3,3), Arrays.asList(6,1,2,3,4,5,6), Arrays.asList(1, 2, 3, 4, 10, -10, -20), 2);
		
//		Object o = new Object();
//		
//		Set s = new TreeSet();
//		s.add("sd");
//		s.add(o);
//		
//		while(s.iterator().hasNext()) {
//			System.out.println(s.iterator().next());
//		}
		
	}

}
