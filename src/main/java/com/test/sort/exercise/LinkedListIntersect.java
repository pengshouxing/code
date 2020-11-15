package com.test.sort.exercise;

public class LinkedListIntersect {

	public static void main(String[] args) {

		ListNode node = new ListNode(3);
		node.next = new ListNode(5);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);

		ListNode node2 = new ListNode(3);
		node2.next = new ListNode(4);
		
		ListNode node3 = new LinkedListIntersect().getIntersectionNode(node,node2);
		node3.toString(node3);

	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null) {
			return null;
		}
		ListNode p = headA;
		ListNode q = headB;
		while(p != q) {
			p = p == null ? headB : p.next;
			q = q == null ? headA : q.next;
		}
		
		return p;
	}

}
