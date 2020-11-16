package com.test.sort.exercise;


/**
 * 检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。
 *
 * 如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。
 *
 * 示例1:
 *
 *  输入：t1 = [1, 2, 3], t2 = [2]
 *  输出：true
 * 示例2:
 *
 *  输入：t1 = [1, null, 2, 4], t2 = [3, 2]
 *  输出：false
 *
 *  解决思路:因为二叉树节点树不能重复，所以比较T2是否属于T1的子树，只需要找到T2的根节点，
 *         依次遍历T2所有的节点树看是否全部相等，如果中途有一个节点数不等，那说明T2不属于T1的子树。
 */
public class IsSubTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(8);
        treeNode.right = new TreeNode(12);
        treeNode.right.left = new TreeNode(11);
        treeNode.right.right = new TreeNode(14);

        TreeNode treeNode2 = new TreeNode(16);



        boolean b = new IsSubTree().checkSubTree(treeNode, treeNode2);
        System.out.println(b);
    }

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        //定义了3个状态 1.是否属于子树的标志 2.子树停止修改1的标志 3.父树停止修改1的标志
        Boolean arr[] = {false,false,false};
        jundgeIsSubTree(t1, t2,arr);
        return arr[0];
    }

    public void jundgeIsSubTree(TreeNode t1, TreeNode t2,Boolean arr[]) {
        //如果遍历完T2的树,那说明T2是T1的子树,不然已经在中途中断了操作。
        if (t1 == null || t2 == null) {
            arr[2] = true;
            return ;
        }
        //判断当前T1和T2的节点的数是否相当，如果相等就从此刻开始比较。
        if (t1.val == t2.val) {
            //因为这里会出现 1>2>3 1>4>3,怕后者3相等把是否子树的标志改成了true。
            if(!arr[1]){
               arr[0] = true;
            }
            jundgeIsSubTree(t1.left, t2.left,arr);
            jundgeIsSubTree(t1.right, t2.right,arr);
        } else {
            //arr[0] 是为了依次遍历T1只有找到了T1和T2有相等的数字才开始进行比较。
            //arr[2] 是担心 1>2>3 2,2相同的时候T2已经是T1的子树了，此时T2已经是空的,怕3进行操作的时候把是否子树的标志改成了false。
            if(arr[0] && !arr[2]){
                arr[0] = false;
                arr[1] = true;
                return ;
            }
            jundgeIsSubTree(t1.left, t2,arr);
            jundgeIsSubTree(t1.right, t2,arr);
        }
    }
}
