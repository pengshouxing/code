package com.test.interger;

public class TestInteger {

	public static void main(String[] args) {

		/**
		 * 编译的时候会进行装箱处理 Integer i1 = Integer.valueof(128);
		 */
		Integer i1 = 128;
		Integer j1 = 128;
		/**
		 * ===比较引用类型的时候，比较的引用对象是否一致，Integer有个-128~127的缓冲区，不在此缓冲区域会生成一个新的对象。
		 */
		System.out.println(i1 == j1);
		
		Integer i2 = 127;
		Integer j2 = 127;
		System.out.println(i2 == j2);
		
		int j3 = 127;
		System.out.println(i2 == j3);
		
		/**
		 * ==比较基本类型的时候，比较的是数值相等。因此会进行拆箱处理
		 */
		int j4 = 128;
		System.out.println(j4 == i1);
	}

}
