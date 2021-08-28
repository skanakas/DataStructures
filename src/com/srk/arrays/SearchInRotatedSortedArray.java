package com.srk.arrays;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int[] arr = {7,8,0,1,2,3,4,5,6};
		
		int l = 0;
		int r = arr.length-1;
		int mid = (l+r) / 2;
		int target = 0 ;
		int index = -1;
		
		while(l<=r) {
			
			mid = (l+r) / 2;
			
			if(arr[mid] == target) {
				index = mid;
				break;
			}
			
			if(arr[mid] >= arr[l]) {
				if(target <= arr[mid] && target >= arr[l]) {
					r = mid-1;
				}else {
					l = mid+1;
				}
			} else {
				if(target >= arr[mid] && target <= arr[mid]) {
					l = mid+1;
				} else {
					r = mid-1;
				}
			}
		}
		
		System.out.println(index);
	}

}
