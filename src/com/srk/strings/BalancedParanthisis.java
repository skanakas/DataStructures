package com.srk.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class BalancedParanthisis {

		Map<Character,Character> map = new HashMap<Character,Character>() {
		private static final long serialVersionUID = 1L;

		{
			put(')','(');
			put('}','{');
			put(']','[');
		}};

		Set<Character> open = new HashSet<Character>(Arrays.asList('(','{','['));
		public boolean isBalancedParentheses(String str) {
			// add your logic here
			if(str == null || str.isEmpty()) return true;

			if(str.length() == 1) return false;

			char[] cArr = str.toCharArray();
			Stack<Character> stack = new Stack<>();
			int i = 0;
			while(i<cArr.length) {
				char c = cArr[i];
				if(open.contains(c))
					stack.push(c);
				else {
					if(stack.isEmpty() || stack.peek()!=map.get(c))
						return false;
					else
						stack.pop();
				}
				i++;
			}
			if(stack.isEmpty())
				return true;
			return false;
		}
		
		public static void main(String[] args) {
			BalancedParanthisis balancedParanthisis = new BalancedParanthisis();
			System.out.println(balancedParanthisis.isBalancedParentheses("({})[]"));
		}
}
