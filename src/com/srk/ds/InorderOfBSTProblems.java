package com.srk.ds;

import com.srk.ds.BinarySearchTree.Node;

public class InorderOfBSTProblems {

	private static Node findMin(Node node) {
		while(node.left != null) {
			node = node.left;
		}
		return node;
	}

	public static Node getSuccessor(Node root, int d) {
		Node successor = null;

		Node node = root;

		while(node!=null) {

			if(d> node.data) {
				node = node.right;
			} else if(d < node.data) {
				successor = node;
				node = node.left;
			} else {
				if(node.right != null) {
					successor = findMin(node.right);
				}
				break;
			}
		}

		return successor;
	}
	
	public static Node findMax(Node node) {
		
		while(node.right != null) {
			node = node.right;
		}
		return node;
	}

	public static Node getPredecessor(Node root, int d) {
		Node predicisor = null;
		Node lastRight = null;
		
		Node node = root;
		
		while(node!= null) {
			
			if(d < node.data) {
				node = node.left;
			} else if(d > node.data) {
				lastRight = node;
				node = node.right;
			} else { //Found d
				if(node.left != null) {
					predicisor = findMax(node.left);
				} else {
					predicisor = lastRight;
				}
				break;
			}
			
		}
		
		return predicisor;
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
		
		System.out.println("Successor:"+getSuccessor(tree.root, 90));
		System.out.println("Predecessor:"+getPredecessor(tree.root,90));
	}

}
