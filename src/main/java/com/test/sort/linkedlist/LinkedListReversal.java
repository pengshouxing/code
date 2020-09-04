package com.test.sort.linkedlist;

/**
 * 链表反转
 * 1.采用头插法
 * @author xiaopeng
 *
 */
public class LinkedListReversal {

	public static void main(String[] args) {
		SingleNode node = new SingleNode(1);
		node.next = new SingleNode(5);
		node.next.next = new SingleNode(3);
		node.next.next.next = new SingleNode(7);
		node.next.next.next.next = new SingleNode(9);

		SingleNode reversal = new LinkedListReversal().reversal(node);
		reversal.toString(reversal);

	}

	public SingleNode reversal(SingleNode node) {
		SingleNode nextNode = null;
		// 创建一个新链表
		SingleNode reNode = new SingleNode(0);
		SingleNode curNode = node;
		while (curNode != null) {
			// 取到下一个链表
			nextNode = curNode.next;
			// 头插法，插入新链表
			curNode.next = reNode.next;//将反转后的链表放入当前节点的下一个节点
			reNode.next = curNode;//然后将当前节点赋给反转链表的下一节点，实现了头插法

			// 把下一个链表赋给当前链表
			curNode = nextNode;
		}
		return reNode.next;
	}
}