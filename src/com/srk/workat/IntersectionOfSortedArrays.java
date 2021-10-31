package com.srk.workat;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfSortedArrays {


	private static List<Integer> intersection (int[] A, int[] B) {
		List<Integer> result = new ArrayList<>();
		int one = 0;
		int two = 0;

		while(one<A.length && two<B.length){
			if(A[one] == B[two]){
				result.add(A[one]);
				one++;
				two++;
			} else {
				if(A[one]<B[two])
					one++;
				else
					two++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(intersection(new int[] {1,2,3,4}, new int[] {1,3,4,5}));
	}


}

