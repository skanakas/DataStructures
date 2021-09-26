package com.srk.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HasCommonAncestor {

	public static void main(String[] args) {
		int[][] arr = { 
					{ 1, 3 }, 
					{ 2, 3 }, 
					{ 3, 6 }, 
					{ 5, 6 }, 
					{ 5, 7 }, 
					{ 4, 5 }, 
					{ 4, 8 }, 
					{ 8, 9 } 
				};
		
		Map<Integer, Set<Integer>> childToParent = new HashMap<>();
		for(int[] pair : arr) {
			int parent = pair[0];
			int child = pair[1];
			
			if(childToParent.get(child) ==null) {
				childToParent.put(child, new HashSet<>());
			}
			childToParent.get(child).add(parent);
		}
		
		Set<Integer> n1Ansistors = new HashSet<>();
		Set<Integer> n2Ansistors = new HashSet<>();
		
		int n1 = 3; int n2 = 8;
		
		fillAncestors(n1Ansistors, childToParent, n1);
		fillAncestors(n2Ansistors, childToParent, n2);
		
		System.out.println(n1Ansistors);
		System.out.println(n2Ansistors);
		
		System.out.println(n1Ansistors.stream().anyMatch(n2Ansistors::contains));
		
	}

	private static void fillAncestors(Set<Integer> parents, 
			Map<Integer, Set<Integer>> childToParent,
			int childNode) {
		
		if(childToParent.containsKey(childNode)) {
			Set<Integer> currentParents = childToParent.get(childNode);
			Iterator<Integer> itr = currentParents.iterator();
			while(itr.hasNext()) {
				Integer p = itr.next();
				if(!parents.contains(p)) {
					parents.add(p);
					fillAncestors(parents, childToParent, p);
				}
			}
		}
	}

}
