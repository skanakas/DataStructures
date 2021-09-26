package com.srk.mergeintervals;

import java.util.Arrays;

public class FindAllConflictingAppointments {

	public static void main(String[] args) {
		
		int [][] appointments = new int[][] {{4,5}, {2,3}, {3,6}, {5,7}, {7,8}};
		int conflicts = 0;
		
		Arrays.sort(appointments, (a,b) -> ((a[0]==b[0]) ? b[1]-a[1] : a[0]-b[0]));
		
		for(int[] i : appointments)
			System.out.println(Arrays.toString(i));
		
		int[] prev = appointments[0];
		for(int i = 1; i<appointments.length; i++) {
			int[] curr = appointments[i];
			
			if(curr[0]>= prev[1]) {
				prev = curr;
			} else if(curr[0] < prev[1]) {
				prev[1] = Math.max(prev[1], curr[1]);
				prev[0] = Math.min(prev[0], curr[0]);
				conflicts++;
			}
			
			
		}
		
		System.out.println(conflicts);
		
		System.out.println(999%10);
		
	}
	
}
