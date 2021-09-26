package com.srk.arrays;

public class SearchInSortedArray {


	public static boolean search2(int[][] matrix, int target) {

		int left = 0;
		int right = matrix.length-1;

		while(left+1 < right){
			int mid = left + (right - left)/2;
			int midVal = matrix[mid][0];
			//int leftVal = matrix[left][0];
			//int rightVal = matrix[right][0];

			if(target < midVal){
				right = mid;
			} else {
				left = mid;
			}
		}
		int row = left;
		System.out.println("row index = "+row);
		return false;

	}
	
	public static void main(String[] args) {
		
		int[][] m = new int[][] {{0, 1, 2, 3},{4, 5, 6, 7},{8, 9, 10, 11}};
		int target = 6;
		search2(m,target);
	}

}
