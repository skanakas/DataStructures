package com.srk.arrays;

public class SearchInSortedArray {

	public static boolean search(int[][] matrix, int target) {
		int nr = matrix.length;
		int nc = matrix[0].length;
		
		int left = 0;
		int right = nr*nc-1;
		
		while(left <= right) {
			int mid = left + (right - left)/2;
			int midVal = matrix[mid/nc][mid%nc];
			
			if(matrix[mid/nc][mid%nc] == target) {
				return true;
			} else if(target > midVal) {
				left = mid+1;
			} else {
				right = mid-1;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		int[][] m = {
								 {10, 11, 12, 13},
						     {14, 15, 16, 17},
						     {27, 29, 30, 31},
						     {32, 33, 39, 80}
						    };
		int target = 30;
		System.out.println(search(m,target));
		
	}

}
