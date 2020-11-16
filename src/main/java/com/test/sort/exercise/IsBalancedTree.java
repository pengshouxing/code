package com.test.sort.exercise;

import com.test.sort.tree.TreeNode;

import java.util.HashMap;

/**
 *
 *实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 *
 *示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 *
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *       1
 *      / \
 *     2   2
 *    / \
 *   3   3
 *  / \
 * 4   4
 * 返回false 。
 *
 * 解决思路:采用了后序遍历的思路来递归，如果有一层子树就加1，如果没有子树就加0。
 * 后序遍历:先访问左子树再访问右子树最后再访问根节点
 */
public class IsBalancedTree {

    private boolean flag = true;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(6);
        treeNode.right.left = new TreeNode(1);
        treeNode.right.right = new TreeNode(7);
        IsBalancedTree isBalancedTree = new IsBalancedTree();
        isBalancedTree.isBalanced(treeNode);
        System.out.println(isBalancedTree.flag);
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        traversal(root);
        return flag;
    }

    public int traversal(TreeNode root) {
        //root == null的时候代表该节点是没有子节点的。
        //!flag == true 的时候代表已经有地方是不满足平衡,所以可以直进返回该树是一颗不平衡的树。
        if(root == null || !flag){
            return 0;
        }
        /**
         *         3
         *        / \
         *       2   6
         *          / \
         *         1  7
         *
         */
        //这边采用递归的思想,如果节点下有其他节点就会加节点的高度,如果没有节点就不加
        int leftDept = traversal(root.left);
        int rightDept = traversal(root.right);
        //判断两棵子树的高度差是否大于1，大于说明就是不平衡的
        if(Math.abs(leftDept - rightDept) > 1){
            flag = false;
        }
        //例如 3的节点左子树高度是1,右边高度是2,所以应该取它的最大高度来和它对应的节点来判断高度差
        return Math.max(leftDept,rightDept) + 1;
    }


}
