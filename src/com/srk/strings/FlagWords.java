package com.srk.strings;

public class FlagWords {
	
	private static boolean flag(String S, String W) {
		
		if(S== null && W != null)
			return false;
		if(W == null)
			return false;
		
		int i = 0;
		int j = 0;
		
		while(i<S.length() && j<W.length()) {
			
			if(S.charAt(i) != W.charAt(j))
				return false;

			int l1 = length(S, i);
			int l2 = length(W, j);
			
			if(l1 < 3 && l1!=l2)
				return false;
			else if(l1>=3 && l1 < l2)
				return false;
			
			i += l1;
			j += l2;
		}
		
		return i==S.length() && j==W.length();
	}

	private static int length(String s, int i) {
		int temp = i;
		while(temp<s.length() && s.charAt(temp) == s.charAt(i))
			temp++;
		
		return temp-i;
	}

	public static void main(String[] args) {
		System.out.println(flag("mooorooonnn", "moron"));
	}

}
