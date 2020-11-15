package com.test.sort.exercise;

public class MergeBinaryTree {

	public static void main(String[] args) {

		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(9);
		t1.right = new TreeNode(2);
		t1.left.left = new TreeNode(4);
		
		TreeNode t2 = new TreeNode(1);
		t2.left = new TreeNode(8);
		t2.right = new TreeNode(3);
		t2.left.right = new TreeNode(7);
		
		TreeNode node = mergeTrees(t1, t2);
		node.tostring(node);
	}

	public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if(t1 == null){
            return t2;
        }
        if(t2 ==null){
            return t1;
        }
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left,t2.left);
        t1.right = mergeTrees(t1.right,t2.right);
        return t1;
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
	
	void  tostring(TreeNode node){
		System.out.print(node.val+"-");
		if(node.left != null) {
			tostring(node.left);
		}
		if(node.right != null) {
			tostring(node.right);
		}
	}
}
