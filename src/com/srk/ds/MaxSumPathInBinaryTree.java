package com.srk.ds;

import java.util.ArrayList;
import java.util.List;

import com.srk.ds.BinarySearchTree.Node;

public class MaxSumPathInBinaryTree {
	
	private static Integer max = 0;
	
	private static List<Integer> getMaxSumPath(Node root){
		
		List<List<Integer>> allPaths = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		findAllPaths(root, path, allPaths);
		for(List<Integer> p : allPaths) {
			System.out.println(p);
		}
		
		Integer currentSum = 0; int maxSum = 0;
		List<Integer> allPathSums = new ArrayList<Integer>();
		findMaxSumPath(root, currentSum , allPathSums);
		System.out.println(allPathSums);
		
		System.out.println("MAX-"+maxSum);
		return allPaths.get(0);
	}

	private static void findMaxSumPath(Node root, Integer currentSum, List<Integer> allPathSums) {
		
		if(root == null) return;
		
		currentSum += root.data;
		
		if(root.left == null && root.right == null) {
			allPathSums.add(new Integer(currentSum));
			max = Math.max(currentSum, max);
			
		} else {
			findMaxSumPath(root.left, currentSum, allPathSums);
			findMaxSumPath(root.right, currentSum, allPathSums);
		}
		
		currentSum -= root.data;
		System.out.println("currentSum-"+new Integer(currentSum)+"| max ="+max);
	}

	private static void findAllPaths(Node root, List<Integer> path, List<List<Integer>> allPaths) {
		
		if(root == null) return;
		
		path.add(root.data);
		
		if(root.left == null && root.right == null) {
			allPaths.add(new ArrayList<>(path));
		} else {
			findAllPaths(root.left, path, allPaths);
			findAllPaths(root.right, path, allPaths);
		}
		path.remove(path.size() - 1);
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

		tree.inorderTraversal(tree.root);
		System.out.println();
		
		getMaxSumPath(tree.root);
	}

}
