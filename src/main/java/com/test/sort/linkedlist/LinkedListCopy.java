package com.test.sort.linkedlist;

/**
 * 链表尾插法参考HashMap
 * @author xiaopeng
 *
 */
public class LinkedListCopy {

	public static void main(String[] args) {
		ListNode node = new ListNode(3);
		node.next = new ListNode(6);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);

		ListNode listNode = new LinkedListCopy().copyLinkedList(node);
		listNode.toString("", listNode);

	}

	public ListNode copyLinkedList(ListNode from) {
		ListNode firstNode = null;
		ListNode lastNode = null;
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
