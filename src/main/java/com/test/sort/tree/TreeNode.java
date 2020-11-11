package com.test.sort.tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class TreeNode {

    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int val) {
        this.val = val;
    }

    public static void printResult(TreeNode treeNode){
        //这里采用层序遍历。从上到下遍历
        Queue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>();
        queue.offer(treeNode);
        while(!queue.isEmpty()) {
            treeNode = queue.poll();
            System.out.print(treeNode.val+" ");
            if(treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if(treeNode.right != null) {
                queue.offer(treeNode.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(-3);
        treeNode.right = new TreeNode(9);
        treeNode.left.left = new TreeNode(-10);
        treeNode.right.left = new TreeNode(5);

        printResult(treeNode);
    }
}
