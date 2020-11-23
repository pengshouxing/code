package com.test.sort.exercise;

/**
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 *
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 *
 * 示例 1:
 *
 * 输入: root = [2,1,3], p = 1
 *
 *   2
 *  / \
 * 1   3
 *
 * 输出: 2
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 *
 *       5
 *      / \
 *     3   6
 *    / \
 *   2   4
 *  /
 * 1
 *
 * 输出: null
 *
 *解决思路:找到指定节点的下个节点是按中序遍历找的下一个节点，中序遍历是有序的(1->2->3),2的下一个节点是3.
 *        先找到我们指定的节点，然后利用标志来判断是否是初始值来进行修改值找到我们想要的值。
 */
public class InorderNodeNext {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        //1.判断是否是初始值，如果两个遍历的节点和指定的节点值相等就说明不是初始值，下一轮遍历的值就是我们想要的结果
        //2.判断是否可以结束了或者初始值是否被改变了，此处有2个作用 a)如果找到了我们想要的结果就没有必要遍历下去,浪费时间。
        //                              b)看我们初始值有没有被改变,如果改变了我们就输出我们改变的值,如果没有改变我们输出null
        Boolean arr[] = {true,false};
        //先随便给个初始值,后序只改变里面的值,不改变引用地址。
        TreeNode retNode = new TreeNode(-1);
        inorderSuccessor(root,p,arr,retNode);
        if(!arr[1]){
            return null;
        }
        return retNode;
    }

    public void inorderSuccessor(TreeNode root, TreeNode p,Boolean arr[],TreeNode retNode) {
        //如果为空或者结果标志为true
        if(root == null || arr[1]){
            return ;
        }
        inorderSuccessor(root.left,p,arr,retNode);
        //判断是否是初始值,如果匹配到了我们想要的节点,那肯定不是初始值,被修改过。
        if(!arr[0]){
            retNode.val = root.val;
            arr[1] = true;
            //如果已经匹配到了我们想要的值,把是否是初始值的标志改回来,怕后面的遍历一直进行进行修改
            arr[0] = true;
        }
        //如果此时匹配到了我们相同的节点,我们就要取下一个节点作为我们输出的节点,但是可能存在一种情况，此时匹配的节点可能是最后一个节点
        //所以下个节点为空的。
        if(root.val == p.val){
            arr[0] = false;
        }
        inorderSuccessor(root.right,p,arr,retNode);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);

        TreeNode inorderNode = new TreeNode(6);

        TreeNode treeNode = new InorderNodeNext().inorderSuccessor(node, inorderNode);
        System.out.println(treeNode);
    }
}
