/**
 * 
 */
package com.company.concurrent.sample.blockingq;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 
 * Uses a blocking queue to implement a producer and consumer (slow)
 * orchestrations
 * 
 * @author NishantS
 *
 */
public class SimpleProducerConsumer {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("****Main Starts****");
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(5);
		Producer producer = new Producer(queue, 1);
		Consumer consumer = new Consumer(queue, 10);

		Thread pThread = new Thread(producer, "Producer");
		Thread cThread = new Thread(consumer, "Consumer");

		pThread.start();
		Thread.sleep(1000);// seep for availability
		cThread.start();
		pThread.join();
		cThread.join();

		consumer.setStopFlag(true);
		System.out.println("****Main Ends****");
	}
}

class Consumer implements Runnable {
	BlockingQueue<String> queue;

	private boolean stopFlag;

	public boolean isStopFlag() {
		return stopFlag;
	}

	public void setStopFlag(boolean stopFlag) {
		this.stopFlag = stopFlag;
	}

	int delay;

	public Consumer(BlockingQueue<String> queue, int delay) {
		super();
		this.queue = queue;
		this.delay = delay;
	}

	public void consume() throws InterruptedException {
		Instant start = Instant.now();
		while (Instant.now().minus(Duration.ofSeconds(60)).isBefore(start)) {
			String item = queue.poll();
			System.out.println("Polled Data - " + item + " Size is - " + queue.size());
			Thread.sleep(delay);
		}
	}

	public void run() {
		try {
			consume();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Producer implements Runnable {
	BlockingQueue<String> dest;

	private Source source;

	int delay;

	public Producer(BlockingQueue<String> queue, int delay) {
		super();
		this.dest = queue;
		source = new Source();
		this.delay = delay;
	}

	public void produce(String data) {
		try {
			dest.put(data);
			System.out.println("Producer.produce()  -  After Put " + data + " Size is" + dest.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		Instant start = Instant.now();
		// run for 2 mins
		while (Instant.now().minus(Duration.ofSeconds(30)).isBefore(start)) {
			String data = source.getData();
			produce(data);
			// System.out.println("Status of Producer is " +
			// Thread.currentThread().getState().toString());
			source.processed(data);
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Processed  -  " + source.processed);
	}
}

class Source {
	List<String> processed;

	public Source() {
		processed = new ArrayList<String>();
	}

	public String getData() {
		return String.valueOf(Instant.now().getEpochSecond());
	}

	public void processed(String data) {
		processed.add(data);
	}
}