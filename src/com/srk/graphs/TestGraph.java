package com.srk.graphs;

public class TestGraph {
	
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
