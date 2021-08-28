package com.srk.ds;

import com.srk.ds.BinarySearchTree.Node;

/**
 * Reverse In Order traversal 
 * 
 * @author arun
 *
 */
public class FindNthHeighestInBST {
	
	private static int heightsNumCnt = 0;
	
	private static Node getNthHeighest(Node node, int n) {
		if(node == null) return null;
		
		Node result = getNthHeighest(node.right, n);
		if(result != null) return result;
		
		heightsNumCnt++;
		if(n == heightsNumCnt) return node;
		
		result = getNthHeighest(node.left, n);
		if(result != null) return result;
		
		return null;
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
		
		Node nthHeighest = getNthHeighest(tree.root, 5);
		System.out.println(nthHeighest);

	}
}
