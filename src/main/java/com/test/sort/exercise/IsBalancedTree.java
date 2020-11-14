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
 */
public class IsBalancedTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(-3);
        treeNode.right = new TreeNode(9);
        treeNode.left.left = new TreeNode(-10);
        treeNode.left.left.right = new TreeNode(-11);
        treeNode.right.left = new TreeNode(5);
        treeNode.right.right = new TreeNode(7);
        new IsBalancedTree().isBalanced(treeNode);
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        HashMap<String, Integer> map = new HashMap<>();
        isBalanced(root , 1 , new HashMap<String,Integer>());
        return map.get("largest") -  map.get("least") > 1 ? false : true ;
    }

    public void isBalanced(TreeNode root, int level, HashMap<String,Integer> map) {

        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            Integer largest = map.get("largest");
            Integer least = map.get("least");
            if(largest == null){
                map.put("largest",level);
                map.put("least",level);
            }else {
                if (level > largest) {
                    map.put("largest", level);
                } else {
                    if (level < least) {
                        map.put("least", level);
                    }
                }
            }
        }

        isBalanced(root.left,level,map);
        isBalanced(root.right,level,map);
    }


}
