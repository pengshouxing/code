package com.test.sort.exercise;


import com.test.sort.linkedlist.ListNode;

/**
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。
 * 如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x只需处于"右半部分"即可，其不需要被置于左右两部分之间。

   示例:
       输入: head = 3->5->8->5->10->2->1, x = 5
       输出: 3->1->2->10->5->5->8

  解决思路:准备两个链表,大于X的节点储存在p1链表中,小于X的节点存储在p2链表中。
                    再准备两个节点,分别存储左链表p1和右链表p2最后一个节点。
                    再遍历节点,把对应的节点放入对应的链表当中。
                    右链表最后一个节点的下个节点甚至下下..下节点可能后面还会有值,
                    所以需要将右链表最后一个节点置为null。
                    左链表不需要置为null因为左链表最后一个节点的下一个节点需要指向右链表的第二个节点,
                    组成一个新的链表返回出去。
                    就算左链表最后一个节点还存在其他节点,也会被忽略掉。
                    
 */
public class PartitionLinkedList {

	public static void main(String[] args) {

		ListNode node = new ListNode(1);
		node.next = new ListNode(5);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(1);
		node.next.next.next.next = new ListNode(2);
		ListNode head = new PartitionLinkedList().partition(node, 5);
		System.out.println(head);
	}

	public ListNode partition(ListNode head, int x) {
		ListNode p1 = new ListNode(0);
		ListNode p2 = new ListNode(0);
		ListNode leftLast = p1;
		ListNode rightLast = p2;
		while (head != null) {
			if (head.val >= x) {
				//把当前节点(可能存在下。。下节点)赋给右链表最后一个节点
				rightLast = rightLast.next = head;
			} else {
				//把当前节点(可能存在下。。下节点)赋给左链表最后一个节点
				leftLast = leftLast.next = head;
			}
			head = head.next;
		}
		//可能rightLast此时为5->3->1->2,只需要存储当前节点5，需要把下一个节点指向为null
		rightLast.next = null;
		//左链表最后一个节点下一个指向右链表的第二个节点
		leftLast.next = p2.next;
		return p1.next;
		
	}

}
