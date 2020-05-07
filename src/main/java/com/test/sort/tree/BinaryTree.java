package com.test.sort.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 二叉树的遍历 
 * 1.前序遍历:先访问根节点再访问左子树最后再访问右子树。
 * 2.中序遍历:先访问左子树再访问根节点最后再访问右子树。
 * 3.后序遍历:先访问左子树再访问右子树最后再访问根节点。
 * 4.层序遍历:层序遍历迭代方式:从上到下分别取出节点。
 *          层序遍历递归方式:同一层存放在同一个List中。
 * 
 * @author xiaopeng
 *
 */
public class BinaryTree {
	
	private static List<List<Integer>> list = new ArrayList<>();

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

		BinaryTree binaryTree = new BinaryTree();
		System.out.print("前序遍历:");
		binaryTree.preorderTraversal(tree);
		System.out.println();		
        System.out.print("中序遍历:");		
        binaryTree.inorderTraversal(tree);
		System.out.println();	
		System.out.print("后序遍历:");
		binaryTree.postorderTraversal(tree);
		System.out.println();	
		System.out.print("层序遍历:");
		binaryTree.sequenceorderTraversal(tree);
		System.out.println();	
		System.out.print("层序遍历递归方式:");
		binaryTree.sequenceorderTraversalRecursionWay(tree, 0);
		for (List<Integer> newList : list) {
			System.out.print(newList);
		}
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
	
	// 层序遍历迭代方式:从上到下分别取出节点。分别放入队列中，再从队列中取出。
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
	
	// 层序遍历递归方式:同一层存放在同一个List中。不同层则新建List存放节点,从左到右添加
	public void sequenceorderTraversalRecursionWay(Tree tree,int level) {
		if(tree == null) return ;
		//判断当前层是否新建过list，没有则新建
		if(level == list.size()) {
			list.add(new ArrayList<Integer>());
		}
		list.get(level).add(tree.val);
		sequenceorderTraversalRecursionWay(tree.leftNode, level+1);
		sequenceorderTraversalRecursionWay(tree.rightNode, level+1);
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
