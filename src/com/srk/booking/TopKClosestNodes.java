package com.srk.booking;

import java.util.LinkedList;
import java.util.List;

public class TopKClosestNodes {

	public static List<Integer> findClosestElements(int[] arr, int k, int x) {

		List<Integer> ll = new LinkedList<>();

		int left = binarySearch(arr,x);
		int right = left+1;
		while(k>0){

			if(left>=0 && right<arr.length){
				int diff1 = Math.abs(x-arr[left]);
				int diff2 = Math.abs(x-arr[right]);
				if(diff1<=diff2){
					ll.add(0,arr[left--]);
				}else{
					ll.add(arr[right++]);
				}
			} else if(left>=0){
				ll.add(0,arr[left--]);
			} else if(right<arr.length){
				ll.add(arr[right++]);
			}
			k--;
		}

		return ll;
	}

	private static int binarySearch(int[] arr, int x) {

		int left = 0;
		int right = arr.length-1;

		while(left<=right) {

			int mid = left + (right-left)/2;
			if(arr[mid] == x) {
				return mid;
			} else if(x > arr[mid]) {
				left = mid+1;
			} else {
				right = mid-1;
			}

		}
		if(left>0) left--;

		return left;
	}


	public static void main(String[] args) {

		System.out.println(findClosestElements(new int[] {1,2,3,4,5}, 4, 3));
		System.out.println(findClosestElements(new int[] {1,2,3,4,5}, 4, -1));

	}

}
