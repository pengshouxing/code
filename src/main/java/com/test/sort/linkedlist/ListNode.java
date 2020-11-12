package com.test.sort.linkedlist;


public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public void toString(String prefix, ListNode node) {
        StringBuilder sb  = new StringBuilder(prefix);
        while (node != null) {
            sb.append(node.val + ">");
            node = node.next;
        }
        System.out.println(sb.substring(0,sb.length()-1));
    }

    /**
     * 在单链表尾部节点添加一个节点
     * 1.当原来节点为空的时候，把要在尾部新增的节点返回出去。
     * 2.当原来节点不为空的时候，把当期节点放到尾部:
     *    a).先把当前节点(node)赋值给一个新的节点(firstNode)，不然到时候返回出去的是最后一个节点再加要新增的节点。
     *    b).然后循环遍历当前节点(node),遍历到最后一个节点(node.next == mull),然后把要新增的节点(addNode)赋值给最后一个节点的下一个节点。
     *
     * @param node:原来节点
     * @param addNode:要在尾部新增的节点
     * @return
     */
    public ListNode addNodeInTail(ListNode node, ListNode addNode) {
        if(node == null){
            return addNode;
        }else{
            ListNode firstNode = node;
            while (node.next != null) {
                node = node.next;
            }
            node.next = addNode;
            return firstNode;
        }
    }

    /**
     *在单链表头部新增一个节点
     * 1.当原来节点为空的时候，把要在头部新增的节点返回出去。
     * 2.当原来节点不为空的时候，把当期节点放到头部:
     *    a)。把要在头部新增的节点下一个节点指向原来节点。
     *
     * @param node:原来节点
     * @param addNode:要在头部新增的节点
     * @return
     */
    public ListNode addNodeInHead(ListNode node , ListNode addNode){
        if (node != null) {
            addNode.next = node;
        }
        return addNode;
    }


    public static void main(String[] args) {
        //测试在尾部添加节点
        ListNode node = new ListNode(0);
        node.next = new ListNode(1);
        ListNode addNode = new ListNode(2);
        ListNode newNode = addNode.addNodeInTail(node, addNode);
        addNode.toString("尾部添加后新的链表0>1>2:",newNode);

        ListNode addNode2 = new ListNode(2);
        ListNode newNode2 = addNode.addNodeInTail(null, addNode2);
        addNode.toString("尾部添加后新的链表2:",newNode2);

        //测试在头部添加节点
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(2);
        ListNode addHeadNode = new ListNode(0);
        ListNode newHeadNode2 = addHeadNode.addNodeInHead(node2, addHeadNode);
        addHeadNode.toString("头部添加后新的链表0>1>2:",newHeadNode2);

        ListNode addHeadNode2 = new ListNode(0);
        ListNode newHeadNode3 = addHeadNode.addNodeInHead(null, addHeadNode2);
        addHeadNode.toString("头部添加后新的链表0:",newHeadNode3);
    }


}
