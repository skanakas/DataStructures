package com.srk.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DELIVERYHERO {

	public static void main(String[] args) {
		//System.out.println(solution(new int[] {0, 1, 0, 1, 0, 1, 0, -1, -2, -3}));

		/**
		 * A -> B, C
		 * B -> C, D
		 * C -> D
		 * 
		 * reverse
		 * B -> A
		 * C -> A, B
		 * D -> B, C
		 */

		String input = "ACCD";

		//[A1, C2, D1]

		Map<Character, Integer> map = new HashMap<>();
		map.put('A', 1);
		map.put('C', 2);
		map.put('D', 1);

		Map<Character, Set<Character>> eatersMap = new HashMap<>();
		eatersMap.put('B', new HashSet<Character>(){{
			add('A');
		}});
		eatersMap.put('C', new HashSet<Character>(){{
			add('A');
			add('B');
		}});
		eatersMap.put('D', new HashSet<Character>(){{
			add('C');
			add('B');
		}});
		
		Map<Character, Set<Character>> canEatMap = new HashMap<>();
		eatersMap.put('A', new HashSet<Character>(){{
			add('B');
			add('C');
		}});
		eatersMap.put('B', new HashSet<Character>(){{
			add('C');
			add('D');
		}});
		eatersMap.put('C', new HashSet<Character>(){{
			add('D');
		}});

		char prevChar = '\0';
		for(int i = 0; i<input.length()-1; i++) {
			char curr = input.charAt(i);
			char next = input.charAt(i+1);

			Set<Character> possibleEaters = eatersMap.get(curr);

			if(possibleEaters != null) {
				if(prevChar != '\0' && possibleEaters.contains(prevChar)) {
					if(map.containsKey(curr)) {
						map.put(curr, map.get(curr)-1);
						if(map.get(curr) == 0)
							map.remove(curr);
					}
				}

				if(possibleEaters.contains(next)) {
					if(map.containsKey(curr)) {
						map.put(curr, map.get(curr)-1);
						if(map.get(curr) == 0)
							map.remove(curr);
					}
				}
			}
			
			Set<Character> canEat = eatersMap.get(curr);
			if(canEat!=null) {
				if(prevChar != '\0' && canEat.contains(prevChar)) {
					if(map.containsKey(prevChar)) {
						map.put(prevChar, map.get(prevChar)-1);
						if(map.get(prevChar) == 0)
							map.remove(prevChar);
					}
				}
				
				if(canEat.contains(next)) {
					if(map.containsKey(next)) {
						map.put(next, map.get(next)-1);
						if(map.get(next) == 0)
							map.remove(next);
					}
				}
			}
			
			prevChar = curr;
		}

		System.out.println(map);


	}


	public static int solution(int[] A) {
		if(A.length <= 1)
			return A.length;

		int start = 0; int max = Integer.MIN_VALUE;
		int prevDiff = Integer.MAX_VALUE;

		for(int i = 0; i< A.length-1; i++) {

			int diff = A[i+1] - A[i];
			if(i==0) {
				prevDiff = diff;
			}


		}
		return -1;


	}

}
