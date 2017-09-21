/**
 * 
 */
package com.company.concurrent.consumer;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 
 * Consumes a batch and processed it
 * 
 * @author nsonar
 *
 */
public class WorkerBatchExecuter {

    ExecutorService executorService;

    List<String> rejectedQueue;

    public WorkerBatchExecuter() {
        // TODO Auto-generated constructor stub
    }

    public void init(BlockingQueue<String> blockingQueue) throws InterruptedException {
        executorService = Executors.newCachedThreadPool();
        String batchedElements = blockingQueue.poll();
        Future<String> returnValues = executorService.submit(new ConsumerProcessor(batchedElements));
        executorService.awaitTermination(2, TimeUnit.MINUTES);
        //String status = returnValues.get();
    }

}
