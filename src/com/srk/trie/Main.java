package com.srk.trie;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) {
		
		Trie trie = new Trie();
		//trie.insert("apple");
		//trie.insert("qwerty");
		//trie.insert("ass");
		//trie.insert("leet");
		//trie.insert("code");
		//trie.insert("allow");
		//trie.insert("a");
		trie.insert("apple");
		trie.insert("peach");
		trie.insert("pear");
		
		/*System.out.println(trie.getWords());
		trie.deleteWord("dad");
		System.out.println(trie.getWords());
		trie.deleteWord("a");
		System.out.println(trie.getWords());
		trie.deleteWord("a");
		System.out.println(trie.getWords());*/
		
		Map<String, Boolean> dp = new HashMap<>();
		String word = "apple";
		
		boolean result = trie.search(word);
		if(!result)
		{
			result = canWordBeFormed(word, trie, dp);
		}
		
		new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		
		System.out.println(result);
	}
	
	public static boolean canWordBeFormed(String word, Trie trie, Map<String, Boolean> dp) {
		
		for(int i = 1; i<word.length(); i++) {
			String first = word.substring(0,i);
			String second = word.substring(i,word.length());
			
			if(dp.get(first)==null) {
				dp.put(first, trie.search(first));
			}
			
			if(dp.get(second) == null) {
				dp.put(second, trie.search(second));
			}
			
			boolean isFirstFound = dp.get(first);
			boolean isSecFound = dp.get(second);
			
			if(isFirstFound && isSecFound)
				return true;
			
			if(isFirstFound && canWordBeFormed(second, trie, dp))
				return true;
			else if(isSecFound && canWordBeFormed(first, trie, dp))
				return true;
		}
		return false;
	}
}
