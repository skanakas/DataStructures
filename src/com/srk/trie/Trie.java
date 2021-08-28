package com.srk.trie;

import java.util.ArrayList;
import java.util.List;

public class Trie {
	
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	public int getIndex(char c) {
		return c-'a';
	}
	
	public boolean hasNoChild(TrieNode node) {
		if(node == null)
			return false;
		
		if(node.children.length == 0)
			return true;
		
		for(int i = 0; i<node.children.length; i++)
		{
			if(node.children[i] !=null)
				return false;
		}
		return true;
	}
	
	
	public void deleteWord(String word) {
		deleteHelper(word, word.length(), this.root, 0);
	}
	
	private boolean deleteHelper(String word, int length, TrieNode node, int level) {
		boolean isSelfDelete = false;
		
		if(node == null)
		{
			return false;
		}
		
		if(length == level) {
			
			if(hasNoChild(node)) {
				node = null;
				isSelfDelete = true;
			} else {
				node.unsetAsLeaf();
				isSelfDelete = false;
			}
			
		} else {
			boolean isChildDeleted = deleteHelper(word,
					length,
					node.children[getIndex(word.charAt(level))], 
					level+1);
			if(isChildDeleted) {
				
				//pointer to be set to null
				node.children[getIndex(word.charAt(level))] = null;
				
				if(node.isEndNode())
					isSelfDelete = false;
				else if(!hasNoChild(node)) {
					isSelfDelete = false;
				} else {
					node = null;
					isSelfDelete = true;
				}
				
			} else {
				isSelfDelete = false;
			}
		}
		return isSelfDelete;
	}

	public void insert(String str) {
		
		if(str == null || str.isEmpty())
			return;
		
		str = str.toLowerCase();
		TrieNode node = this.root;
		
		for(int level=0; level<str.length(); level++) {
			
			TrieNode child = node.children[getIndex(str.charAt(level))];
			if(child == null) {
				node.children[getIndex(str.charAt(level))] = new TrieNode();
			}
			
			node = node.children[getIndex(str.charAt(level))];
		}
		node.markAsLeaf(); //NOTE : IMPORTANT
	}
	
	public boolean search(String key) {
		if(key==null)
			return false;
		
		if(key.isEmpty())
			return true;
		
		TrieNode currNode = this.root;
		key = key.toLowerCase();
		
		for(int i = 0; i<key.length(); i++) {
			TrieNode child = currNode.children[getIndex(key.charAt(i))];
			
			if(child == null) return false;
			
			currNode = child;
		}
		
		if(currNode.isEndNode()) return true;
		
		return false;
	}
	
	public List<String> getWords(){
		
		List<String> words = new ArrayList<>();
		
		char[] arr = new char[26];
		getWordsHelper(this.root, 0, words, arr);
		
		return words;
		
	}

	private void getWordsHelper(TrieNode node, int level, List<String> words, char[] arr) {
		
		if(node.isEndNode()) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i<level; i++) {
				sb.append(arr[i]);
			}
			words.add(sb.toString());
		}
		
		for(int i = 0; i<26; i++) {
			if(node.children[i]!= null) {
				arr[level] = (char) (i+'a');
				getWordsHelper(node.children[i], level+1, words, arr);
			}
		}
	}
	
	public boolean canWordBeFormed(String word) {
		for(int i = 0; i<word.length(); i++) {
			String first = word.substring(0,i);
			String second = word.substring(i,word.length());
			
			if(this.search(first) && this.search(second))
				return true;
			
			if(this.search(first) && canWordBeFormed(second))
				return true;
			else if(this.search(second) && canWordBeFormed(first))
				return true;
		}
		return false;
	}

}
