package com.srk.arrays;

public class MultiplicationOfTwoNums {

	public static void main(String[] args) {
		
		int a[] = {-1,2,3}, b[]= {2,4,2};
		int result[] = new int[a.length+b.length];
				
		int sign = a[0]<0||b[0]<0 ? -1:1;
		a[0] *= sign;
		
		for(int i =a.length-1; i>=0; i--) {
			for(int j=b.length-1; j>=0; j--) {
				int n = j+i+1;
				
				int mul = a[i]*b[j];
				int mod = mul%10;
				result[n] += mod;
				
				int modCarry = 0;
				if(result[n]/10 > 0) {
					modCarry = result[n]/10;
					result[n] = result[n]%10;
				}
				
				
				int carry = mul/10+modCarry;
				result[n-1] += carry;
				printArray(result);
			}
		}
	}
	
	public static void printArray(int arr[]) {
		for(int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
	}

}
