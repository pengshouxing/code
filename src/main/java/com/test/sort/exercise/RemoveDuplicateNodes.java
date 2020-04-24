package com.test.sort.exercise;

/**
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * 
 * 示例1:
       输入：[1, 2, 3, 3, 2, 1]
       输出：[1, 2, 3]
       
   示例2:
       输入：[1, 1, 1, 1, 2]
       输出：[1, 2]    
       
  解决思路:定义一个数组，默认值都是false。用一个lastNode表示返回节点的最后一个节点,有新节点加入返回节点则重新赋值lastNode。
                    再遍历输入节点,先看节点值在数组中存在,如果该节点值不存在,把数组这个位置改为true。
                    把这个节点添加到最后节点。如果该节点值存在,则跳过。
                    
     提示：
     链表长度在[0, 20000]范围内。
     链表元素在[0, 20000]范围内。
 * @author xiaopeng
 *
 */
public class RemoveDuplicateNodes {

	public static void main(String[] args) {

		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(1);
		System.out.println(new RemoveDuplicateNodes().removeDuplicateNodes(node));
	}

	public ListNode removeDuplicateNodes(ListNode head) {
		if (head == null) {
			return null;
		}
		boolean[] flag = new boolean[20001];
		ListNode newNode = null, lastNode = null;
		while (head != null) {
			// 如果为false,说明不存在该值
			if (!flag[head.val]) {
				if (newNode == null) {
					newNode = new ListNode(head.val);
					lastNode = newNode;
				} else {
					lastNode.next = new ListNode(head.val);
					lastNode = lastNode.next;
				}
				flag[head.val] = true;
			}
			head = head.next;
		}
		return newNode;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	public void toString(ListNode node) {
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
}
