package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by IntelliJ IDEA.
 * User: ojha
 * Date: 6/18/13
 * Time: 11:27 AM
 */
public class SimpleThreadPool {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        System.out.println("-----Starting all Threads-----");
        for (int i=1; i <= 10; i++){
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()){}
        System.out.println("-----Finished all Threads-----");
    }
}
