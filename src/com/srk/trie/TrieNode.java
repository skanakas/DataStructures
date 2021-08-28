package com.srk.trie;

public class TrieNode {
	
	private boolean isEndNode;
	public TrieNode[] children;
	
	public TrieNode() {
		isEndNode = false;
		children = new TrieNode[26];
	}
	
	public boolean isEndNode() {
		return isEndNode;
	}

	public void markAsLeaf() {
		this.isEndNode = true;
	}
	
	public void unsetAsLeaf() {
		this.isEndNode = false;
	}
	
	
}
