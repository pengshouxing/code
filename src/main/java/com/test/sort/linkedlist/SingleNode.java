package com.test.sort.linkedlist;

public class SingleNode {

	int val;
	SingleNode next;

	SingleNode(int x) {
		val = x;
	}

	public void toString(SingleNode node) {
		while (node != null) {
			System.out.print(node.val + ">");
			node = node.next;
		}
	}

	/**
	 * 在尾部添加
	 * 
	 * @param singleNode
	 * @param addNode
	 */
	public void addNodeInTail(SingleNode singleNode, SingleNode addNode) {
		if (singleNode == null) {
			addNode = singleNode;
			System.out.println(addNode);
		} else {
			while (singleNode.next != null) {
				singleNode = singleNode.next;
			}
			singleNode.next = addNode;
		}
	}

	public static void main(String[] args) {
		SingleNode node = null;
		SingleNode addNode = new SingleNode(2);
		addNode.addNodeInTail(node, addNode);
		System.out.println(node);
		addNode.toString(node);
	}

}
