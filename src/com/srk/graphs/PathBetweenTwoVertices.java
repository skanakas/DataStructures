package com.srk.graphs;

import java.util.Arrays;
import java.util.Stack;

public class PathBetweenTwoVertices {

	private boolean pathExists(Graph g, Integer source, Integer dest) {
		
		boolean[] visited = new boolean[g.vertices];
		Arrays.fill(visited, false);
		
		Stack<Integer> stack = new Stack<>();
		stack.push(source);
		visited[source] = true;

		while(!stack.isEmpty()) {
			
			Integer node = stack.pop();
			
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(9);

		g.addEdge(0,2);
		g.addEdge(0,5);
		g.addEdge(2,3);
		g.addEdge(2,4);
		g.addEdge(5,3);
		g.addEdge(5,6);
		g.addEdge(3,6);
		g.addEdge(6,7);
		g.addEdge(6,8);
		g.addEdge(6,4);
		g.addEdge(7,8);
		
		g.printGraph();
		
		
	}

}
