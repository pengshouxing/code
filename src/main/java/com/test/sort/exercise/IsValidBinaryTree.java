package com.test.sort.exercise;


/**
 *
 * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
 *
 * 示例1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 *
 * 示例2:
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 *解决思路:采用中序遍历的思想，因为二叉树的中序遍历是从小到大的有序。(左节点 --> 根节点 --> 右节点)
 *
 */
public class IsValidBinaryTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);


        boolean b = new IsValidBinaryTree().isValidBST(treeNode);
        System.out.println(b);
    }

    public boolean isValidBST(TreeNode root) {
        //两个标志 1.是否是二叉搜索树 2.表示上个节点是否是初始值,因为会存在一种情况只有一个节点恰好和初始值一样。
        Boolean arr[] = {true,true};
        isValidBST(root,arr,new TreeNode(0));
        return arr[0];
    }

    public void isValidBST(TreeNode root, Boolean arr[],TreeNode preNode) {
        //!arr[0]已经有值不符合二叉搜索树,所以就可以退出了,判定该树不是二叉搜索树.
        if (root == null || !arr[0]) {
            return;
        }
        //中序遍历
        isValidBST(root.left, arr,preNode);
        //如果不是初始值并且上个节点大于等于当前节点,那就说明不符合二叉搜索树的特性
        if(!arr[1] && root.val <= preNode.val){
            arr[0] = false;
        }
        //上个节点已经比较完了，进行下一轮比较,那么下个节点的值应该和当前节点的值进行比较,那么应该把当前节点的值赋给上个节点。
        preNode.val = root.val;
        //已经进行了比较,上个节点的值已经改变了,那么肯定已经不是初始值。
        arr[1] = false;
        isValidBST(root.right, arr,preNode);

    }

}
