package com.test.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

	public static void main(String[] args) throws InterruptedException {
		
		//核心线程池
		int corePoolSize = 1;
		//最大线程池
		int maximumPoolSize = 5;
		//在队列取出任务等待时间(空闲线程的等待时间),如果设置allowCoreThreadTimeOut,核心线程没有任务也会变成空闲线程。
		long keepAliveTime = 0l;
		//在队列取出任务等待时间单位
		TimeUnit unit = TimeUnit.MILLISECONDS;
		//阻塞队列,可以队列长度
		BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>(2);
		ExecutorService ex = new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
				keepAliveTime, unit,workQueue);
		ex.execute(() -> System.out.println(Thread.currentThread()));
		ex.execute(() -> System.out.println(Thread.currentThread()));
        ex.shutdown();
	}

}
