package com.srk.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MinWindowString {
    public static String minWindow(String s, String t) {
        
    	Map<Character, Integer> dicMap = new HashMap<>();
    	for(char c : t.toCharArray()) {
    		dicMap.put(c, dicMap.getOrDefault(c, 0)+1);
        }
    	
    	String dicKey = dicMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(k->k, v->v)).toString();
    	String currKey = "";
    	
        int min = Integer.MAX_VALUE;
        int currSize = 0; String res = null;
        Map<Character, Integer> currMap = new HashMap<>();
        int start = 0, end = 0;
        while(end < s.length()) {
            char c = s.charAt(end);
            
            if(dicMap.containsKey(c)) {
            	currMap.put(c, currMap.getOrDefault(c, 0)+1);
            }
            currKey = currMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(k->k, v->v)).toString();
            
            while(currMap.size() == dicMap.size() && currKey.equals(dicKey)){
                currSize = end-start+1;
                if(currSize<min) {
                	min = currSize;
                	res = s.substring(start, end+1); 
                }
                char startChar = s.charAt(start);
                if(currMap.containsKey(startChar)) {
                	currMap.put(startChar, currMap.get(startChar)-1);
                	if(currMap.get(startChar)==0)
                		currMap.remove(startChar);
                }
                start++;
            } 
            end++;
             
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }
}
