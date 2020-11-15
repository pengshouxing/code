package com.test.lock;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock implements Runnable {

	private int i = 1;
	
	private ReentrantLock lock = new ReentrantLock(false);

	public static void main(String[] args) {
		TestLock testLock = new TestLock();
		int j = 0;
		while (j < 10) {
			Thread t = new Thread(testLock);
			t.start();
			j++;
		}
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread()+": ");
		lock.lock();
		System.out.println(Thread.currentThread()+"测试数字:" + i++);
		lock.unlock();
	}

}
