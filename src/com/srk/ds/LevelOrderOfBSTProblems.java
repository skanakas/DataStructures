package com.srk.ds;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.srk.ds.BinarySearchTree.Node;

public class LevelOrderOfBSTProblems {

	public static void levelOrderTraverse(Node root) {
		Queue<Node> queue = new ArrayDeque<>();
		Node nullNOde = new Node(0);

		queue.add(root);
		queue.add(nullNOde);

		while(!queue.isEmpty()) {

			Node node = queue.poll();
			System.out.print(node+" ");

			if(node.left != null) 
				queue.add(node.left);

			if(node.right != null) {
				queue.add(node.right);
			}

			if(queue.peek() == nullNOde) {
				queue.remove();
				if(!queue.isEmpty()) {
					queue.add(nullNOde);
				}
				System.out.println();
			}
		}

	}

	private static List<Float> getLevelAvg(Node root){

		List<Float> avgs = new ArrayList<>();

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			int levelSum = 0;

			for(int i = 0; i<levelSize; i++) {
				Node node = queue.poll();
				levelSum += node.data;

				if(node.left != null) queue.add(node.left);

				if(node.right != null) queue.add(node.right);
			}
			Float avg = levelSum/(float)levelSize;
			avgs.add(avg);
		}

		return avgs;

	}

	private static List<Float> getLargestInEachLevel(Node root){

		List<Float> avgs = new ArrayList<>();

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			int largest = 0;

			for(int i = 0; i<levelSize; i++) {
				Node node = queue.poll();
				largest = Math.max(largest, node.data);

				if(node.left != null) queue.add(node.left);

				if(node.right != null) queue.add(node.right);
			}
			
			avgs.add((float)largest);
		}
		
		return avgs;
	}
	
	private static List<List<Integer>> zigzagTraversal(Node root) {
		
		List<List<Integer>> result = new ArrayList<>();
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		boolean leftToRight = true;
		
		while(!queue.isEmpty()) {
			List<Integer> levelData = new LinkedList<>();
			int levelSize = queue.size();			
			for(int i = 0; i<levelSize; i++) {
				Node node = queue.poll();
				
				if(node.left != null) queue.add(node.left);
				
				if(node.right != null) queue.add(node.right);
				
				if(leftToRight) {
					levelData.add(node.data);
				}
				else {
					levelData.add(0, node.data);
				}
			}
			result.add(levelData);
			leftToRight = !leftToRight;
		}
		
		return result;
		
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(50);tree.insert(16);tree.insert(14);
		tree.insert(10);tree.insert(5);tree.insert(15);
		tree.insert(40);tree.insert(35);tree.insert(36);
		tree.insert(37);tree.insert(38);tree.insert(45);
		tree.insert(90);tree.insert(78);tree.insert(75);
		tree.insert(82);tree.insert(81);tree.insert(85);
		tree.insert(79);tree.insert(87);tree.insert(100);

		levelOrderTraverse(tree.root);
		System.out.println(getLevelAvg(tree.root));
		System.out.println(getLargestInEachLevel(tree.root));
		
		for(List<Integer> ints : zigzagTraversal(tree.root)) {
			System.out.println(ints);
		}

	}

}
