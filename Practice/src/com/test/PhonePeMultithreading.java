package com.test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import org.json.simple.JSONObject;

class Producer implements Runnable {

	private BlockingQueue<JSONObject> queue;
	static final int TOTAL_MSG = 50;

	Producer(BlockingQueue<JSONObject> queue) {
		this.queue = queue;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void run() {

		for (int i = 0; i < TOTAL_MSG; i++) {
			try {
				JSONObject obj = new JSONObject();
				obj.put("message", "Producing message number " + (i + 1));
				obj.put("id", i+1);
				System.out.println("Producing element.....");
				queue.put(obj);
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}

class Consumer implements Runnable {

	private BlockingQueue<JSONObject> queue;
	private CountDownLatch countDownLatch;

	Consumer(BlockingQueue<JSONObject> queue, CountDownLatch count) {
		this.queue = queue;
		this.countDownLatch = count;
	}

	@Override
	public void run() {

		while (true) {
			if (countDownLatch.getCount() == 0)
				break;
			try {
				JSONObject obj = queue.take();
				System.out.println("Consuming msg.. with msg id: " + obj.get("id")+ " and Message Content: " + obj.get("message"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				countDownLatch.countDown();
			}
		}
	}
}

public class PhonePeMultithreading {

	public static void main(String arg[]) {

		BlockingQueue<JSONObject> queue = new LinkedBlockingQueue<>();

		Producer producer = new Producer(queue);
		new Thread(producer).start();
		CountDownLatch countDownLatch = new CountDownLatch(Producer.TOTAL_MSG);

		// Here we have the 5 consumer.
		Consumer consumer = new Consumer(queue, countDownLatch);
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for (int i = 1; i <= 5; i++) {
			executor.submit(consumer);
		}
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Stopped");
		executor.shutdown();
	}

}
