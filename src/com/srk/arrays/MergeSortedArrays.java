package com.srk.arrays;

import java.util.Arrays;

public class MergeSortedArrays {

	public static void main(String[] args) {
		
		//int[] a1 = {5,9,10,15,20};
		//int[] a2 = {2,3,8,13};
		int[] a1 = {1,2,3};
		int[] a2 = {2,5,6};
		
		int m = a1.length;
		int n = a2.length;
		
		for(int i = n-1; i>=0; i--) {
						
			int j = 0;
			int last = a1[m-1];
			
			for(j=m-2; j>=0 && a1[j] > a2[i]  ;j--) {
				a1[j+1] = a1[j]; // right shift
			}
			
			if(j!= m-2 || last > a2[i]) {
				a1[j+1] = a2[i];
				a2[i] = last;
			}
			
		}
		
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(a2));
		
	}

}
