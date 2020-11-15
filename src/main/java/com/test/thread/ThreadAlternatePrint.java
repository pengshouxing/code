package com.test.thread;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;

/**
 * 
 * 输入: n = 1 输出: "foobar" 解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar()
 * 方法，"foobar" 将被输出一次。
 * 
 * 输入: n = 2 输出: "foobarfoobar" 解释: "foobar" 将被输出两次。
 *
 */
public class ThreadAlternatePrint {

	private int n = 3;

	private CountDownLatch countLatch = new CountDownLatch(1);
	private CountDownLatch countLatch2 = new CountDownLatch(0);

	@Test
	public void testOne() {

		Thread fooThread = new Thread(new Runnable() {
			@Override
			public void run() {
				foo();
			}
		});

		Thread barThread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					bar();
				} catch (InterruptedException e) {
				}
			}
		});

		barThread.start();
		fooThread.start();

	}

	public void foo() {
		for (int i = 0; i < n; i++) {
			try {
				countLatch2.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("foo");
			countLatch.countDown();
			countLatch2 = new CountDownLatch(1);
		}
	}

	public void bar() throws InterruptedException {
		for (int i = 0; i < n; i++) {
			countLatch.await();
			System.out.print("bar");
			countLatch = new CountDownLatch(1);
			countLatch2.countDown();
		}
	}

}
