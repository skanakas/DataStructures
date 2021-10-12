package com.srk.booking;

public class DecodeTheString {
	
	private static String getSolution(String input, int N) {
		
		int rows = N;
		int cols = input.length()/rows;
		int[][] arr = new int[rows][cols];
		
		int index = 0;
		char[] strArr = input.toCharArray();
		
		for(int r = 0; r<rows; r++) {
			for(int c = 0; c<cols; c++) {
				char ch = strArr[index++];
				arr[r][c] = (ch=='_')?' ':ch;
			}
			//System.out.println(Arrays.toString(arr[r]));
		}
		
		StringBuilder sb = new StringBuilder();
		for(int d=0; d<cols; d++) {
			
			for(int i = 0; i<rows; i++) {
				int j = d+i;
				
				if(j>=cols) break;
				
				sb.append((char)arr[i][j]);
			}
			
		}
		return sb.toString();
	}
	

	public static void main(String[] args) {
		String input = "mnesi___ya__k____mime";
		int rows = 3;
		
		System.out.println(getSolution(input, rows));
	}

}
