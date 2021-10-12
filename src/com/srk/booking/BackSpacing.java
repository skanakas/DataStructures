package com.srk.booking;

import java.util.Arrays;

/**
 * 
 * Backspacing
 * 	
  	i/p -> "abc#def##"
		o/p -> "abd"
 *
 */
public class BackSpacing {

	private static String parseString(String input) {
		
		if(input == null || input.isEmpty())
			return input;
		
		char[] arr = input.toCharArray();
		int charIndex = -1;
		int i = 0;
		while(i<arr.length) {
			if(arr[i] != '#') {
				charIndex++;
				arr[charIndex] = arr[i];
			} else if(charIndex>=0) {
				charIndex--;
			}
			i++;
		}
		
		if(charIndex < 0)
		{
			return "";
		}
		
		StringBuilder sb = new StringBuilder();
		i = 0;
		while(i<=charIndex) {
			sb.append((char)arr[i++]);
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		//System.out.println(parseString("abc#def##"));//abd
		System.out.println(parseString("#####a#"));
	}

}
