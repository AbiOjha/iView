package iview.deadlock;

import java.util.concurrent.*;

/**
 * Created by IntelliJ IDEA.
 * User: ojha
 * Date: 6/17/13
 * Time: 1:08 AM
 */
class Worker implements Callable<String>{


    @Override
    public String call() throws Exception {
        return "result";
    }
}
public class ThreadWithResultExample {
        static ExecutorService exec = Executors.newCachedThreadPool();
    public static void main(String[] args) {
        Future result = exec.submit(new Worker());
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ExecutionException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        exec.shutdown();
    }
}
