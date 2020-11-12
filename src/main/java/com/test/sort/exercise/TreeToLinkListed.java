package com.test.sort.exercise;

import com.test.sort.linkedlist.ListNode;
import com.test.sort.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 *
 * 示例：
 *
 * 输入：[1,2,3,4,5,null,7,8]
 *
 *         1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 *    /
 *   8
 *
 * 输出：[[1],[2,3],[4,5,7],[8]]
 *
 * 解决思路:从上到下取出所有的元素(层序遍历),每一层级从左到右形成一个链表
 *
 */
public class TreeToLinkListed {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(-3);
        treeNode.right = new TreeNode(9);
        treeNode.left.left = new TreeNode(-10);
        treeNode.left.left.right = new TreeNode(-11);
        treeNode.right.left = new TreeNode(5);
        treeNode.right.right = new TreeNode(7);

        ListNode[] listNodes = new TreeToLinkListed().listOfDepth(treeNode);
        if(listNodes != null){
            for (int i = 0; i < listNodes.length; i++) {
                new ListNode(0).toString("树深度为"+(i+1)+"的时候节点为:",listNodes[i]);
            }
        }
    }

    /**
     * 将树转成链表数组，每一层树对应数组一个位置。
     * 层树:这里从上到下算的。
     * @param tree
     * @return
     */
    public ListNode[] listOfDepth(TreeNode tree) {
        //方便后面转成数组(leetcode上要求转成数组)。树的每一层对应hashMap一个位置。key为第几层-1(key从0开始),value为每一层形成的单链表
        HashMap<Integer,ListNode> hashMap = new HashMap<Integer,ListNode>();
        int nums = 0;
        listOfDepth(tree,0,hashMap);
        //将hashmap转成单链表数组
        Set<Integer> keys = hashMap.keySet();
        if(keys != null){
            ListNode[] nodes =  new ListNode[keys.size()];
            for (Integer i:keys) {
                ListNode listNode = hashMap.get(i);
                nodes[nums] = listNode;
                nums++;

            }
            return nodes;
        }
        return null;
    }

    public void listOfDepth(TreeNode tree,int nums,HashMap<Integer,ListNode> hashMap) {
        if(tree == null){
            return ;
        }
        //看当前层，是否已经存在了链表，如果存在了需要插入到尾部，如果不存在，则新建一个链表
        ListNode listNode = hashMap.get(nums);
        if(listNode == null){
            listNode = new ListNode(tree.val);
        }else{
            //操作:存在了需要插入到尾部
            //将存在的链表赋值给当期节点，再遍历当前当前节点直到最后一个节点(curNode.next == null)，
            ListNode curNode = listNode;
            while(curNode.next!= null){
                curNode = curNode.next;
            }
            // 然后将新加的节点放入当前节点的下一个节点
            curNode.next= new ListNode(tree.val);
        }
        hashMap.put(nums,listNode);
        //递归左半树
        listOfDepth(tree.left,nums+1,hashMap);
        //递归右半树
        listOfDepth(tree.right,nums+1,hashMap);
    }
}
