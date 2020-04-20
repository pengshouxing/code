package com.test.sort.exercise;


/**
 * 实现一种算法，删除单向链表中间的某个节点（除了第一个和最后一个节点，不一定是中间节点），
 * 假定你只能访问该节点。
 * 
 * 示例：
         输入：单向链表a->b->c->d->e->f中的节点c
         结果：不返回任何数据，但该链表变为a->b->d->e->f
         
   解决思路:当前上送的是删除的节点,将当前节点值改成下个节点值,把当前节点的下一个指针指向
                     当前节点的下下个节点。就相当于把当前节点删除了
 * @author xiaopeng
 *
 */
public class DeleteMiddleNode {

	public static void main(String[] args) {

		ListNode node = new ListNode(4);
		node.next = new ListNode(5);
		node.next.next = new ListNode(1);
		node.next.next.next = new ListNode(9);
		new DeleteMiddleNode().deleteNode(node.next);
		System.out.println(node);
	}

	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}

}
