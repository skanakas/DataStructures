package com.srk.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Node implements Comparable<Node> {
	
	Map<Character, Node> children = null;
	boolean isEnd = false;
	String data = "";
	int rank = 0;
	List<Node> hot = null;
	
	Node(){
		children = new HashMap<>();
		hot = new ArrayList<>();
	}

	@Override
	public int compareTo(Node node) {
		if(this.rank == node.rank)
			return node.data.compareTo(this.data);
		return node.rank - this.rank;
	}
	
	public void update(Node i) {
		if(!hot.contains(i))
			hot.add(i);
		Collections.sort(hot);
		while(hot.size()>3) {
			hot.remove(hot.size()-1);
		}
	}
}

public class AutoCompleteSearch {
	
	Node root;
	Node current;
	String seachString;
	
	public AutoCompleteSearch(String sentence[], Integer[] rank) {
		
		this.root = new Node();
		this.current = this.root;
		this.seachString = "";
		
		for(int i = 0; i<sentence.length; i++) {
			this.addRecord(sentence[i], rank[i]);
		}
		
	}

	private void addRecord(String sentence, Integer rank) {
		Node record = this.root;
		List<Node> visited = new ArrayList<>();
		for(Character c: sentence.toCharArray()) {
			if(!record.children.containsKey(c))
				record.children.put(c, new Node());
			visited.add(record);
			record = record.children.get(c);
		}
		record.isEnd = true;
		record.data = sentence;
		record.rank += rank;
		
		for(Node v:visited) {
			v.update(record);
		}
	}
	
	public List<String> autoComplete(Character c) {
		if(c == '#') {
			addRecord(this.seachString, 1);
			this.seachString = "";
			this.current = this.root;
			return Collections.emptyList();
		}
		
		this.seachString += c;
		
		if(this.current == null)
			return Collections.emptyList();
		
		if(!this.current.children.containsKey(c))
			return Collections.emptyList();
		
		this.current = this.current.children.get(c);

		return this.current.hot.stream().map(node-> node.data).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		String[] sentences = {"beautiful", "best quotes", "best friend", "best birthday wishes", "instagram", "internet"};
        Integer[] times = {30, 14, 21, 10, 40, 15};
        AutoCompleteSearch auto = new AutoCompleteSearch(sentences, times);
        System.out.println(auto.autoComplete('b'));
        System.out.println(auto.autoComplete('e'));
        System.out.println(auto.autoComplete('s'));
        System.out.println(auto.autoComplete('t'));
        System.out.println(auto.autoComplete('e'));
        System.out.println(auto.autoComplete('s'));
        System.out.println(auto.autoComplete('t'));
        System.out.println(auto.autoComplete('#'));
        
        System.out.println(auto.autoComplete('b'));
        System.out.println(auto.autoComplete('e'));
        System.out.println(auto.autoComplete('s'));
        System.out.println(auto.autoComplete('t'));
        System.out.println(auto.autoComplete('e'));
        System.out.println(auto.autoComplete('s'));
        System.out.println(auto.autoComplete('t'));
        System.out.println(auto.autoComplete('#'));
	}

}
