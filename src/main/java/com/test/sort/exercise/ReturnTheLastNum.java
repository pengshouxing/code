package com.test.sort.exercise;

/**
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * 
 * 示例：
            输入： 1->2->3->4->5 和 k = 2
            输出： 4
            
   解决思路:采用双指针。第一个指针指向头部,第二个指针从头部开始移动k下。
                     等待第二个指针指向空节点时候，此时第一个指针指向就是倒数k的位置。
 * @author xiaopeng
 *
 */
public class ReturnTheLastNum {

	public static void main(String[] args) {

		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(10);
		System.out.println(new ReturnTheLastNum().kthToLast(node, 3));
	}

	public int kthToLast(ListNode head, int k) {
		ListNode p = head;
		//让第二个指针移动k个距离
		for (int i = 0; i < k; i++) {
			p = p.next;
		}
		while (p != null) {
			p = p.next;
			head = head.next;
		}
		return head.val;
	}

}
