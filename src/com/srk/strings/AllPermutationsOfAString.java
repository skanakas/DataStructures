package com.srk.strings;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class AllPermutationsOfAString {

	static Set<String> set = new LinkedHashSet<>();
	
	public static void main(String[] args) {
		String s = "abc";
		char[] c = s.toCharArray();
		permute(c, 0, c.length-1);
	}
	
	private static void permute(char[] c, int left, int right) {

		if(left == right) {
			System.out.println(Arrays.toString(c));
		} else {

			for(int i = left; i<=right; i++) {

				swap(c, left, i);

				permute(c, left+1, right);

				swap(c, i, left);
			}
		}

	}

	private static void swap(char[] c, int l, int r) {
		char temp = c[l];
		c[l] = c[r];
		c[r] = temp;
	}

}
