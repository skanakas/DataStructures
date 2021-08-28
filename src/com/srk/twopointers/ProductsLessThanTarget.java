package com.srk.twopointers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProductsLessThanTarget {

	public static void main(String[] args) {
		int[] arr = {8,2,6,5};
		int target = 50;
		
		int left = 0;
		int right = 0;
		int prod = 1;
		List<List<Integer>> result = new ArrayList<>();
		
		while(right<=arr.length-1) {
			prod *= arr[right];
			
			while(prod>=target && left<arr.length) {
				prod/=arr[left++];
			}
			
			List<Integer> temp = new LinkedList<>();
			int i = right;
			while(left<=i) {
				temp.add(0,arr[i--]);
				result.add(new ArrayList<>(temp));
			}
			System.out.println(result);
			right++;
		}
		System.out.println(result);
	}

}
