package com.srk.twopointers;

public class StringEqualsWithBackSpaces {

	public static void main(String[] args) {

		char[] arr1 = "xz#z".toCharArray();
		char[] arr2 = "xzz#".toCharArray();
		boolean result = equals(arr1, arr2);
		System.out.println(result);
		
	}

	private static boolean equals(char[] arr1, char[] arr2) {
		
		int l1 = arr1.length-1;
		int l2 = arr2.length-1;
		
		while(l1>=0 && l2>=0) {
			
			int s1 = 0;
			while(l1>=0) {
				if(arr1[l1] == '#') {
					s1++;
					l1--;
				} else if(s1>0) {
					s1--;
					l1--;
				} else
					break;
			}
			
			int s2 = 0;
			while(l2>=0) {
				if(arr2[l2] == '#') {
					s2++;
					l2--;
				} else if(s2>0) {
					s2--;
					l2--;
				} else
					break;
			}
			
			if(l1>=0 && l2>=0 && arr1[l1]!=arr2[l2])
				return false;
			
			if(l1>=0 != l2>=0) return false;
			
			l1--;
			l2--;
			
		}
		
		return true;
	}

}
