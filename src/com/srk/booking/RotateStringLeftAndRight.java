package com.srk.booking;

public class RotateStringLeftAndRight {

	public static void main(String[] args) {
		String input = "qwerty";
		int d = 2;
		
		//SOLUTION START
		
		d = d % input.length();
		/**
		 * Rotate left
		 */
		System.out.println(rotateLeft(input, d));
		
		/**
		 * Rotate right
		 */
		System.out.println(rotateRight(input, d));
		System.out.println(rotateLeft(input, input.length()-d));
	}
	
	private static String rotateLeft(String input, int d) {
		
		char[] arr = input.toCharArray();
		reverse(arr, 0, d-1);
		reverse(arr, d, arr.length-1);
		reverse(arr, 0, arr.length-1);
		
		return new String(arr);
	}

	private static String rotateRight(String input, int d) {
		
		return rotateLeft(input, input.length()-d);
		
	}
	
	private static void reverse(char[] arr, int start, int end) {
		
		while(start<end) {
			char temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		
	}

	

}
