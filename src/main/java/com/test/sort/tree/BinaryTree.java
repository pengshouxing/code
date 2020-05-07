package com.test.sort.tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 二叉树的遍历 
 * 1.前序遍历:先访问根节点再访问左子树最后再访问右子树。
 * 2.中序遍历:先访问左子树再访问根节点最后再访问右子树。
 * 3.后序遍历:先访问左子树再访问右子树最后再访问根节点。
 * 4.层序遍历:层序遍历:从上到下分别取出节点。
 * 
 * @author xiaopeng
 *
 */
public class BinaryTree {

	public static void main(String[] args) {

		Tree tree = new Tree(10);
		tree.leftNode = new Tree(8);
		tree.rightNode = new Tree(20);
		

		tree.leftNode.leftNode = new Tree(6);
		tree.leftNode.rightNode = new Tree(9);

		tree.leftNode.leftNode.leftNode = new Tree(4);
		tree.leftNode.leftNode.rightNode = new Tree(7);
		
		tree.rightNode.rightNode = new Tree(22);
		tree.rightNode.rightNode.leftNode = new Tree(21);
		tree.rightNode.rightNode.rightNode = new Tree(24);

		System.out.print("前序遍历:");
		new BinaryTree().preorderTraversal(tree);
		System.out.println();		
        System.out.print("中序遍历:");		
		new BinaryTree().inorderTraversal(tree);
		System.out.println();	
		System.out.print("后序遍历:");
		new BinaryTree().postorderTraversal(tree);
		System.out.println();	
		System.out.print("层序遍历:");
		new BinaryTree().sequenceorderTraversal(tree);
	}

	// 前序遍历:先访问根节点再访问左子树,最后再访问右子树。
	public void preorderTraversal(Tree tree) {
		if (tree == null) return;
		System.out.print(tree.val+" ");
		preorderTraversal(tree.leftNode);
		preorderTraversal(tree.rightNode);
	}

	// 中序遍历:先访问左子树再访问根节点最后再访问右子树。
	public void inorderTraversal(Tree tree) {
		if (tree == null) return;
		inorderTraversal(tree.leftNode);
		System.out.print(tree.val+" ");
		inorderTraversal(tree.rightNode);
	}
	
	// 后序遍历:先访问左子树再访问右子树最后再访问根节点。
	public void postorderTraversal(Tree tree) {
		if (tree == null) return;
		postorderTraversal(tree.leftNode);
		postorderTraversal(tree.rightNode);
		System.out.print(tree.val+" ");
	}
	
	// 层序遍历:从上到下分别取出节点。分别放入队列中，再从队列中取出。
	public void sequenceorderTraversal(Tree tree) {
		Queue<Tree> queue = new LinkedBlockingQueue<Tree>();
		queue.offer(tree);
		while(!queue.isEmpty()) {
			tree = queue.poll();
			System.out.print(tree.val+" ");
			if(tree.leftNode != null) {
				queue.offer(tree.leftNode);
			}
			if(tree.rightNode != null) {
				queue.offer(tree.rightNode);
			}
		}
	}

}

class Tree {
	Tree leftNode;
	Tree rightNode;
	int val;

	public Tree(int val) {
		this.val = val;
	}
}
