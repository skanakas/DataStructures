package com.srk.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class Graph {

	int vertices;
	LinkedList<Integer>[] dll = null;

	public Graph(int v) {
		this.vertices = v;
		dll = new LinkedList[this.vertices];
		for(int i = 0; i<vertices; i++) {
			dll[i] = new LinkedList<>();
		}
	}

	public void addEdge(int source, int dest) {
		if(source<vertices && dest < vertices) {
			this.dll[source].addLast(dest);
			//this.dll[dest].addLast(source);
		}
	}

	public void printGraph()
	{
		System.out.println(">>Adjacency List of Directed Graph<<");
		for (int i = 0; i < vertices; i++)
		{
			if(dll[i]!=null){
				System.out.print("|" + i + "| => ");

				ListIterator<Integer> listIterator = dll[i].listIterator();
				while (listIterator.hasNext())
				{
					System.out.print("[" + listIterator.next() + "] -> ");
				}
				System.out.println("null");
			}
			else{

				System.out.println("|" + i + "| => "+ "null");
			}
		}
	}
}
