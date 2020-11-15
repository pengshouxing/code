package com.test.sort.exercise;

import com.test.sort.linkedlist.ListNode;

/**
 * 给定两个用链表表示的整数，每个节点包含一个数位。
       这些数位是反向存放的，也就是个位排在链表首部。
       编写函数对这两个整数求和，并用链表形式返回结果。
       
   示例：
        输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
        输出：2 -> 1 -> 9，即912
        
  解决思路:新建一个链表和链表中最后的节点。遍历l1和l2的节点,给链表尾端中循环插入新的节点。
                    有可能存在l1和l2的节点不一样。l1 2 -> 8 l2 3 ->5 ->9,输出 5 -> 3 ->0 ->1
                    有可能所有节点遍历完成,但是最后一个节点相加>10,需要再重新加一个新的节点。
 * @author xiaopeng
 *
 */
public class TwoLinkedListSum {

	public static void main(String[] args) {

		ListNode l1 = new ListNode(7);
		l1.next = new ListNode(1);
		l1.next.next = new ListNode(6);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(8);
		l2.next.next = new ListNode(6);

		ListNode node = new TwoLinkedListSum().addTwoNumbers(l1, l2);
		node.toString("",node);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode p = new ListNode(-1);
		ListNode lastNode = p;
		int sum =0;
		while(l1 != null || l2 != null) {
			int l1Val = 0;
			if(l1 != null) {
				l1Val =l1.val;
				l1 = l1.next;
			}
			int l2Val = 0;
			if(l2 != null) {
				l2Val = l2.val;
				l2 = l2.next;
			}
			int value = (l1Val + l2Val + sum)%10;
			sum = (l1Val + l2Val + sum)/10;
			lastNode.next = new ListNode(value);
			lastNode = lastNode.next;
		}
		//l1和l2最后一个节点+sum如果大于10,需要进一位,再在最后一个节点上加一个新的节点。
		if(l1 == null && l2 == null && sum != 0) {
			lastNode.next = new ListNode(sum);
		}
		return p.next;
	}

}
