package com.srk.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		int[][] result = threeSum(new int[] {3, 0, 6, 6, 2, 2, 5, -8, -1});
		for(int[] nums : result) {
			System.out.println(Arrays.toString(nums));
		}
	}

	public static int[][] threeSum(int[] numbers){
		List<int[]> triplets = new ArrayList<>();
		Arrays.sort(numbers);
		int n = numbers.length;
		for(int i = 0; i<n && (i==0||numbers[i-1]!=numbers[i]); i++) {
			int first = numbers[i];
			int left = i+1;
			int right = n-1;

			while(left < right) {
				int checkSum = first + numbers[left] + numbers[right];
				if(checkSum == 0){
					triplets.add(new int[]{first, numbers[left],numbers[right]});
					
					right--;
					left++;
					
					while(left<right && numbers[left-1] == numbers[left])
						left++;
				} else if(checkSum > 0){
					right--;
					while(left<right && numbers[right+1] == numbers[right])
						right--;
				} else {
					left++;
					while(left<right && numbers[left-1] == numbers[left])
						left++;
				}
			}
		}
		int[][] ans = triplets.toArray(new int[triplets.size()][]);
		return ans;
	}

}
