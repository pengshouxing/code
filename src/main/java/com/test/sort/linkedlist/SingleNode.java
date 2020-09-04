package com.test.sort.linkedlist;


public class SingleNode {
	
	int val;
	SingleNode next;

	SingleNode(int x) {
		val = x;
	}

	public void toString(SingleNode node) {
		while (node != null) {
			System.out.print(node.val+">");
			node = node.next;
		}
	}
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("abc");
		sb.append("def");
	}

}
