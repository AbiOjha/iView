package threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by IntelliJ IDEA.
 * User: ojha
 * Date: 6/18/13
 * Time: 11:45 AM
 */
public class WorkerPool {
    public static void main(String[] args) {
        // Rejected execution handler
        RejectedExecutionHandler rejectionHandler = new RejectedExecutionHandlerImpl();

        //Get Threadfactory
        ThreadFactory threadFactory = Executors.defaultThreadFactory();

        //Creating ThreadPoolExecutor

    }
}
