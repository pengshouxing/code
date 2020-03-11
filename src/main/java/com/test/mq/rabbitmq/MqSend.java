package com.test.mq.rabbitmq;

import java.nio.charset.StandardCharsets;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class MqSend {
	private final static String QUEUE_NAME = "hello";

	public static void main(String[] argv) throws Exception {
		cpmfirmSend();
	}

	//comfirm模式:所有在该信道上发布的消息都将会被指派一个唯一的ID（从1开始）
	public static void cpmfirmSend() throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
			// //durable==true代表队列持久
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			String message = "Hello World!";

			// 开启发送方确认模式
			channel.confirmSelect();
			//BasicProperties=MessageProperties.PERSISTENT_TEXT_PLAIN=2代表消息持久
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
			if (channel.waitForConfirms()) {
				System.out.println("消息发送成功");
			}

			System.out.println(" [x] Sent '" + message + "'");
		}
	}

	// 事务模式:缺点吞吐量下降
	public static void txSend() throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			String message = "Hello World!";
			try {
				// 开启事务
				channel.txSelect();
				channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
				channel.txCommit();
			} catch (Exception e) {
				// 事务回滚
				channel.txRollback();
			}
			System.out.println(" [x] Sent '" + message + "'");
		}
	}
}
