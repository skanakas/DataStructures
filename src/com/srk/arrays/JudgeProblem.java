package com.srk.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class JudgeProblem {

	public static void main(String[] args) {
		char[][] data = {{'A','C'},{'B','C'},{'C','F'},{'D','E'},{'E','F'},{'A','B'},{'D','B'},{'D','A'}};
		
		int[] dependency = new int[26];
		Set<Character> set = new HashSet<>();
		
		for(int i = 0; i<data.length; i++) {
			char key = data[i][0];
			set.add(key);
			char val = data[i][1];
			set.add(val);
			
			int index = val-'A';
			dependency[index]++;
		}
		
		System.out.println(Arrays.toString(dependency));
		
		Character judge = '\0';
		for(Character c : set) {
			if(dependency[(char)c - 'A'] == 0)
				judge = c;
			System.out.println(c+"---"+dependency[(char)c - 'A']);
		}
		
		System.out.println("JUDGE --- "+judge);

	}

}
