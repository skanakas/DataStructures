package com.srk.strings;

public class StringSequenceCount {

	public static void main(String[] args) {
		
		System.out.println(getDetails("WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWBWWWWWWWWWWWWWW"));
		//12W1B12W3B24W1B14W
		//12W1B12W3B24W1B14W
	}
	
	private static String getDetails(String input) {
		
		if( input == null
		    || input.isEmpty()) {
			return "";
		}
		
		StringBuilder sb = new StringBuilder();
		char[] arr = input.toCharArray();
		
		int start = 0;
		int end = 0;
		while(end < arr.length) {
			char startChar = arr[start];
			if(startChar != arr[end]) {
				int count = end-start;
				sb.append(count).append(startChar);
				start = end;
			}
			end++;
		}
		
		if(start<end) {
			char startChar = arr[start];
			int count = end-start;
			sb.append(count).append(startChar);
		}
		
		return sb.toString();
	}

}
