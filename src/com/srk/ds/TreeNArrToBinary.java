package com.srk.ds;

import com.srk.ds.BinarySearchTree.Node;

public class TreeNArrToBinary {
	
	private static Node convertToBinary(TreeNode root) {
		return convertToBinary(root, true);
	}

	private static Node convertToBinary(TreeNode root, boolean left) {
		if(root == null)
			return null;
		
		Node node = new Node(root.key);
		Node last = node;
		
		for(int i = 0; i < root.child.size(); i++) {
			if(left) {
				last.left = convertToBinary(root.child.get(i), false);
				last = last.left;
			} else {
				last.right = convertToBinary(root.child.get(i),true);
				last = last.right;
			}
		}
		return node;
	}
	
	private static TreeNode convertToTreeNode(Node node) {
		return convertToTreeNode(node, true);
	}

	private static TreeNode convertToTreeNode(Node node, boolean left) {
		if(node == null)
			return null;
		
		TreeNode treeNode = new TreeNode(node.data);
		Node last = node;
		if(left) {
			while(last.left != null) {
				TreeNode child = convertToTreeNode(last.left, false);
				treeNode.child.add(child);
				last = last.left;
			}
		} else {
			while(last.right != null) {
				TreeNode child = convertToTreeNode(last.right, true);
				treeNode.child.add(child);
				last = last.right;
			}
		}
		return treeNode;
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.addChild(new TreeNode(2));
		TreeNode three = new TreeNode(3);
		node.addChild(three);
		node.addChild(new TreeNode(6));
		
		three.addChild(new TreeNode(4));
		TreeNode fiv = new TreeNode(5);
		three.addChild(fiv);
		
		TreeNode seven = new TreeNode(7);
		fiv.addChild(seven);
		
		seven.addChild(new TreeNode(8));
		TreeNode nine = new TreeNode(9);
		seven.addChild(nine);
		seven.addChild(new TreeNode(10));
		
		nine.addChild(new TreeNode(11));nine.addChild(new TreeNode(12));nine.addChild(new TreeNode(13));
		
		Node convertToBinary = convertToBinary(node);
		//LevelOrderOfBSTProblems.levelOrderTraverse(convertToBinary);
		
		System.out.println(convertToTreeNode(convertToBinary));
		
	}

}
