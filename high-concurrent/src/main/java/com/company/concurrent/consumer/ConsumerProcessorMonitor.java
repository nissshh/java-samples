/**
 * 
 */
package com.company.concurrent.consumer;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author nsonar
 *
 */
public class ConsumerProcessorMonitor extends FutureTask<ConsumerProcessor> {

    public ConsumerProcessorMonitor(Callable<ConsumerProcessor> arg0) {
        super(arg0);
    }

}
