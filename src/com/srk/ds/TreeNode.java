package com.srk.ds;

import java.util.Vector;

public class TreeNode
{
    int key;
    Vector<TreeNode> child = new Vector<>();
 
    public TreeNode(int data)
    {
        key = data;
    }
    
    public void addChild(TreeNode c) {
    	child.add(c);
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TreeNode [key=").append(key).append(", child=").append(child).append("]");
		return builder.toString();
	}
    
};
