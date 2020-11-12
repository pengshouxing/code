package com.test.sort.linkedlist;


import org.junit.Test;

public class SingleNode {

    public int val;
    public SingleNode next;

    public SingleNode(int x) {
        val = x;
    }

    public void toString(SingleNode node) {
        StringBuilder sb  = new StringBuilder();
        while (node != null) {
            sb.append(node.val + ">");
            node = node.next;
        }
        System.out.println(sb.substring(0,sb.length()-1));
    }

    /**
     * 在尾部添加节点
     * 1.当原来节点为空的时候，把当前添加的节点返回出去。
     * 2.当原来节点不为空的时候，把当期节点到尾部:
     *    a).先把当前节点(node)赋值给一个新的节点(firstNode)，不然到时候返回出去的是最后一个节点再加要新增的节点。
     *    b).然后循环遍历当前节点(node),遍历到最后一个节点(node.next == mull),然后把要新增的节点(addNode)赋值给最后一个节点的下一个节点。
     *
     * @param node:原来节点
     * @param addNode:要在尾部新增的节点
     * @return
     */
    public SingleNode addNodeInTail(SingleNode node, SingleNode addNode) {
        if(node == null){
            return addNode;
        }else{
            SingleNode firstNode = node;
            while (node.next != null) {
                node = node.next;
            }
            node.next = addNode;
            return firstNode;
        }
    }


    public static void main(String[] args) {
        //测试在尾部添加节点
        SingleNode node = new SingleNode(0);
        node.next = new SingleNode(1);
        SingleNode addNode = new SingleNode(2);
        SingleNode newNode = addNode.addNodeInTail(null, addNode);
        addNode.toString(newNode);
    }


}
