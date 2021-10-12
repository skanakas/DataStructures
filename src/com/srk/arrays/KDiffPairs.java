package com.srk.arrays;

public class KDiffPairs {
	private static int kDiffPairs (int[] A, int k) {
		
		if(k==0) return 0;
		
		int count = 0;
		int left = 0;
		int right = 0;
		while(right<A.length){
			int diff = Math.abs(A[left]-A[right]);

			if(diff>=k) {
				if(diff==k)
					count++;
				left++;
				
				while(left<right && A[left]==A[left-1])
					left++;
				
			} else {
				right++;
				
				while(right<A.length && A[right] == A[right-1])
					right++;
				
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		
		System.out.println(kDiffPairs(new int[] {1,3,3,7,10}, 2));
		System.out.println(kDiffPairs(new int[] {1,3,5,7,10}, 3));
		
	}
}
