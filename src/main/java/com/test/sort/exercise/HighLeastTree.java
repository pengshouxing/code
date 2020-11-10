package com.test.sort.exercise;


import com.test.sort.tree.TreeNode;

import static com.test.sort.tree.TreeNode.printResult;

/**
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 *
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *           0
 *          / \
 *        -3   9
 *        /   /
 *      -10  5
 *
 *
 * 解题思路:因为是有序排列，所以要树高度最小是取中间那个数作为根节点。
 *        取完中间那个节点作为根节点，以中间数为界限把左边化为左半区，右边化为右半区。(注意:左半区到时候也会出现化为左右半区的,右半区到时候也会出现左半区的)
 *        依次递归下去，当没有一个半区(4,4)左界限大于等于右界限的时候，就结束了。
 *
 */
public class HighLeastTree {

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5};
        TreeNode treeNode = new HighLeastTree().sortedArrayToBST(nums);
        printResult(treeNode);
    }

    public  TreeNode sortedArrayToBST(int[] nums) {
         if(nums.length == 0){
            return null;
         }
        TreeNode treeNode = sortedArrayToBST(nums, 0, nums.length);
        return treeNode;
    }

    public  TreeNode sortedArrayToBST(int[] nums,int left,int right){
        if(left >= right){
            return null;
        }
        //求中间节点
        int middle = (left + right) / 2;
        TreeNode nextNode = new TreeNode(nums[middle]);
        //给左子树赋值
        nextNode.left = sortedArrayToBST(nums,left,middle);
        //给右子树赋值
        nextNode.right = sortedArrayToBST(nums,middle+1,right);
        return nextNode;
    }
}
