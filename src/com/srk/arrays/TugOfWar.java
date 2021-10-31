package com.srk.arrays;

import java.util.ArrayList;

public class TugOfWar {
	
	public static void main(String[] args) {
		TugOfWar obj = new TugOfWar();
		System.out.println(obj.divideGroup(new int[] {1,2,3,4}));
		System.out.println(obj.divideGroup(new int[] {5,1,2,8}));
		System.out.println(obj.divideGroup(new int[] {1,2,3,4,5}));
	}
	
	int minDiff = Integer.MAX_VALUE;
	int divideGroup(int[] A) {

		if(A == null || A.length == 0)
			return 0;

		if(A.length == 1)
			return A[0];

		minDiff = Integer.MAX_VALUE;
		
		solve(A, 0, new ArrayList<Integer>(), new ArrayList<Integer>(), 0, 0);

		return minDiff;

	}

	String ans = "";

	private void solve(int[] A, int index, ArrayList<Integer> s1, ArrayList<Integer> s2, int sum1, int sum2){

		if(index == A.length){
			int delta = Math.abs(sum1-sum2);
			if(delta < minDiff)
			{
				minDiff = delta;
				ans = s1 +"  "+s2;
				System.out.println(ans);
			}
			return;
		}

		if(s1.size() < (A.length+1)/2){
			s1.add(A[index]);
			solve(A, index+1, s1, s2, sum1+A[index], sum2);
			s1.remove(s1.size()-1);
		} 

		if(s2.size() < (A.length+1)/2){
			s2.add(A[index]);
			solve(A, index+1, s1, s2, sum1, sum2+A[index]);
			s2.remove(s2.size()-1);
		}
	}
}
