package com.srk.collection;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class LeaderBoard {

	private Map<Integer, Integer> playerToScoreMap = new HashMap<>();
	private TreeMap<Integer, Set<Integer>> scoreToPlayersMap = new TreeMap<>(Comparator.reverseOrder());

	public void addUserScore(Integer userId, Integer score) {
		Integer preScore = playerToScoreMap.getOrDefault(userId, 0);
		playerToScoreMap.put(userId, preScore+score);
		Integer totScore = playerToScoreMap.get(userId);
		if(scoreToPlayersMap.containsKey(preScore)) {
			scoreToPlayersMap.get(preScore).remove(userId);
		}
		scoreToPlayersMap.putIfAbsent(totScore, new HashSet<>());
		scoreToPlayersMap.get(totScore).add(userId);
	}

	public Set<Integer> topKUsers(int k) {
		Set<Integer> topKUsers = new HashSet<>();
		int i = 0;
		for(Entry<Integer, Set<Integer>> scoreBoard : scoreToPlayersMap.entrySet()) {
			if(i<=k) {
				Set<Integer> users = scoreBoard.getValue();
				if(users.size()+i <= k) {
					topKUsers.addAll(users);
					i += users.size();
				} else {
					for(Integer u : users) {
						if(i<=k) {
							topKUsers.add(u);
							i++;
						}
						else
							break;
					}
				}
			}
			
			if(i>=k){
				break;
			}
		}
		return topKUsers;
	}
	
	public static void main(String[] args) {
		LeaderBoard leaderBoard = new LeaderBoard();
		leaderBoard.addUserScore(1, 20);
		leaderBoard.addUserScore(1, 30);
		leaderBoard.addUserScore(2, 30);
		leaderBoard.addUserScore(3, 20);
		leaderBoard.addUserScore(3, 40);
		leaderBoard.addUserScore(1, 20);
		leaderBoard.addUserScore(2, 30);
		leaderBoard.addUserScore(3, 20);
	}
}
