package com.srk.strings;

public class RemoveDuplicate {

	public static void main(String[] args) {
		
		String in = "///as//f/e///s////g/h/h///j";
		
		char[] c = in.toCharArray();
		
		int index = 0;
		
		for(int i = 0; i<c.length; i++) {
			while(i>0 && c[i] == '/' && c[i] == c[i-1]) {
				 i++;
			}
			c[index++] = c[i];
		}
		
		for(int i = 0; i<index; i++) {
			System.out.print(c[i]);
		}
		
		//System.out.println(Arrays.toString(c));
	}

}
