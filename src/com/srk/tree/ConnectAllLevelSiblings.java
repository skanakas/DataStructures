package com.srk.tree;

import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode next;

	TreeNode(int x) {
		val = x;
		left = right = next = null;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("->").append(val).append("->").append(next);
		return builder.toString();
	}
	
	
};

public class ConnectAllLevelSiblings {
	public static void connect(TreeNode root) {
		Queue<TreeNode> q = new ArrayDeque<>();
		q.offer(root);

		TreeNode prevLevLastNode = null;
		TreeNode currFirstNode = null;
		while(!q.isEmpty()) {
			int levelSize = q.size();
			TreeNode levelRoot = null;
			for(int i = 0; i< levelSize; i++) {
				if(levelRoot == null) {
					levelRoot = q.poll();
					currFirstNode = levelRoot;
				}
				else {
					levelRoot.next = q.poll();
					levelRoot = levelRoot.next;
				}

				if(levelRoot.left != null)
					q.offer(levelRoot.left);
				if(levelRoot.right != null)
					q.offer(levelRoot.right);
			}
			if(prevLevLastNode != null)
				prevLevLastNode.next = currFirstNode;
			prevLevLastNode = levelRoot;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		ConnectAllLevelSiblings.connect(root);

		// level order traversal using 'next' pointer
		TreeNode current = root;
		System.out.println("Traversal using 'next' pointer: ");
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
	}
}
