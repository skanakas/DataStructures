package com.srk.arrays;

import java.util.Arrays;

public class MaxSum {

	public static void main(String[] args) {
		int s = 15, n = 2;
		
		int[] sum = new int[n];
		
		for(int i = 0; i<n; i++) {
			if(s>=9) {
				sum[i]=9;
				s=s-9;
				
			}else {
				sum[i]=s;
				s=0;
			}
		}
		
		
		
		System.out.println(Arrays.toString(sum));
	}

}
