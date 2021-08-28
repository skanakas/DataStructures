package com.srk.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrippletsSumIsZero {

	public static void main(String[] args) {
		int arr[] = {-3,0,1,2,-1,1,-2};

		List<List<Integer>> triplets = new ArrayList<>();

		Arrays.sort(arr);

		for(int i = 0; i<arr.length-2; i++) {

			if(i>0 && arr[i] == arr[i-1]) continue; // to remove duplicates

			int first = i;
			int left = i+1;
			int right = arr.length-1;

			while(left<right) {
				int checkSum = arr[first]+arr[left]+arr[right];
				if(checkSum == 0) {
					triplets.add(Arrays.asList(arr[first],arr[left],arr[right]));
					left++;
					right--;
					while(left<right && arr[left-1]==arr[left]) // to remove duplicates
						left++;
					while(left<right && arr[right+1] == arr[right]) // to remove duplicates
						right--;
				} else if(checkSum < 0){
					left++;
				} else
					right--;
			}
		}
		
		System.out.println(triplets);
	}
}
