package com.test.sort.linkedlist;

/**
 * 链表尾插法参考HashMap
 * @author xiaopeng
 *
 */
public class LinkedListCopy {

	public static void main(String[] args) {
		SingleNode node = new SingleNode(3);
		node.next = new SingleNode(6);
		node.next.next = new SingleNode(3);
		node.next.next.next = new SingleNode(4);

		SingleNode singleNode = new LinkedListCopy().copyLinkedList(node);
		singleNode.toString("",singleNode);

	}

	public SingleNode copyLinkedList(SingleNode from) {
		SingleNode firstNode = null;
		SingleNode lastNode = null;
		while (from != null) {
			if (from.val % 2 == 0) {
				if (firstNode == null) {
					firstNode = from;
				} else {
					lastNode.next = from;
				}
				lastNode = from;
			}
			from = from.next;
		}
		return firstNode;
	}

}
