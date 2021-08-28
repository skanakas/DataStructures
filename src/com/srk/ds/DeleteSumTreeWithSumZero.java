package com.srk.ds;

import com.srk.ds.BinarySearchTree.Node;

public class DeleteSumTreeWithSumZero {
	
	private static void deleteOnZeroSum(Node node) {
		if(node == null)
			return;
		
		int sum = sumAfterDelete(node);
		if(sum == 0) 
			node = null;
	}

	private static int sumAfterDelete(Node node) {
		
		if(node == null) return 0;
		
		int sum_l = sumAfterDelete(node.left);
		int sum_r = sumAfterDelete(node.right);
		
		if(sum_l == 0)
			node.left = null;
		if(sum_r == 0)
			node.right = null;
		
		return node.data+sum_l+sum_r;
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(-5);
		tree.insert(15);
		

		tree.inorderTraversal(tree.root);
		System.out.println("\n**********************************");
		deleteOnZeroSum(tree.root);
		
		tree.inorderTraversal(tree.root);
		System.out.println();
		
		
	}

}
