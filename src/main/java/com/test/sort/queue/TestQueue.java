package com.test.sort.queue;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class TestQueue {

	public static void main(String[] args) throws InterruptedException {

		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>(3);
		queue.offer("1");
		queue.offer("2");
		queue.offer("3");
		//offer如果队列中消息超过队列长度,就会默认被丢弃。
		queue.offer("5");
		
		//put如果队列中消息超过队列长度,会进行等待队列消息被取出。然后再放入队列中
		//queue.put("6");
		
		//poll会把该元素从队列中取出
		System.out.println(queue.poll()+"剩余长度"+queue.size());
		System.out.println(queue.poll()+"剩余长度"+queue.size());
		System.out.println(queue.poll(4l,TimeUnit.SECONDS)+"剩余长度"+queue.size());
		//peek不会把该元素从对列中取出
		System.out.println(queue.peek()+"剩余长度"+queue.size());
		System.out.println(queue.poll()+"剩余长度"+queue.size());
		//take如果队列中没有消息,需要等待消息添加,会把消息从对列中取出
		queue.put("4");
		System.out.println(queue.take()+"剩余长度"+queue.size());
	}

}
