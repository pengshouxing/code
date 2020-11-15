package com.test.sort.exercise;

public class LinkedListIsPalindrome {

	public static void main(String[] args) {

		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(2);
		l1.next.next.next = new ListNode(1);
		
		System.out.println(new LinkedListIsPalindrome().isPalindrome(l1));
		
	}
	
	public boolean isPalindrome(ListNode head) {

		ListNode totalNode = head;
		int total = 1;
		while(head != null) {
			total += 1;
			totalNode = totalNode.next;
		}
		
		//找到中间节点
		ListNode midNode = head;
		for (int i = 0; i < total/2; i++) {
			midNode = midNode.next;
		}
		
		//将后面链表进行反转
		ListNode preNode = null;
		ListNode nextNode = null;
		ListNode temp = midNode;
		for (int i = 0; i < total/2; i++) {
			temp = temp.next;
			preNode = temp;
			preNode.next = preNode;
		}
		
		return false;
    }

}
