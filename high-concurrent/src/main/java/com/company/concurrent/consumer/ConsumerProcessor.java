/**
 * 
 */
package com.company.concurrent.consumer;

import java.util.concurrent.Callable;

/**
 * @author nsonar
 *
 */
public class ConsumerProcessor implements Callable<String> {

    String data;

    public ConsumerProcessor(String data) {
        // TODO Auto-generated constructor stub
    }

    public String call() throws Exception {
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException ie) {
            System.err.println("Thread " + Thread.currentThread() + " interubpted" + ie.getMessage());
        }
        String status = "Completed";// improve bu using Enums
        synchronized (data) {
            data = data.toUpperCase();
        }
        String printMsg = String.format("Converted Message....%s by Thread %", data, Thread.currentThread());
        System.out.println(printMsg);
        return status;
    }

}
