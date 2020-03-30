package com.test.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

/**
 * 线程按照顺序执行
 * @author xiaopeng
 *
 */
public class ThreadOrderExecute {
	
	public CountDownLatch countDown1 = new CountDownLatch(1);
	public CountDownLatch countDown2 = new CountDownLatch(1);

	/**
	 * 线程按照顺序执行:第一种方法使用CountDownLatch,使用await()方法会让当前线程进行等待,等待CountDownLatch.countDown()让state
	 *              减为0以后会唤醒进行等待的线程。
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}                
				System.out.println("当前线程:"+Thread.currentThread()+"第一位");
				countDown1.countDown();
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				 try {
					countDown1.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
                 System.out.println("当前线程:"+Thread.currentThread()+"第二位");
                 countDown2.countDown();
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					countDown2.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
                 System.out.println("当前线程:"+Thread.currentThread()+"第三位");
			}
		}).start();
		
		Thread.sleep(3000);
	}
	
	/**
	 * 线程按照顺序执行:第二种方法使用Thread.join()方法。让当前线程进行等待,join的线程执行完会执行notifyall唤醒当前线程。
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception{
		Thread thread1 = new Thread(()->{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("当前线程:"+Thread.currentThread()+"第一位");
		});
		thread1.start();
		thread1.join();
		
		Thread thread2 = new Thread(()->{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("当前线程:"+Thread.currentThread()+"第二位");
		});
		thread2.start();
		thread2.join();
		
		Thread thread3 = new Thread(()->{
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("当前线程:"+Thread.currentThread()+"第三位");
		});
		thread3.start();
		thread3.join();
		
		Thread.sleep(3000);
	}

	/**
	 * 线程按照顺序执行:第三种方法使用线程池。开启一个核心进行工作,其他任务放到对列里面,队列是先进先出,执行完一个
	 *              就会去对列里面取。
	 */
	@Test
	public void test3(){
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.execute(() -> {
			System.out.println("当前线程:"+Thread.currentThread()+"第一位");
		});
		
		executor.execute(() -> {
			System.out.println("当前线程:"+Thread.currentThread()+"第二位");
		});
		
		executor.execute(() -> {
			System.out.println("当前线程:"+Thread.currentThread()+"第三位");
		});
	}
}
