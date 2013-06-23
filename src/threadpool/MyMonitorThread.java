package threadpool;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by IntelliJ IDEA.
 * User: ojha
 * Date: 6/18/13
 * Time: 11:34 AM
 */
public class MyMonitorThread implements Runnable {
    private ThreadPoolExecutor executor;
    private int seconds;
    private boolean run = true;

    public MyMonitorThread(ThreadPoolExecutor executor, int seconds) {
        this.executor = executor;
        this.seconds = seconds;
    }

    public void shutdown(){
        this.run = false;
    }

    @Override
    public void run() {
        while (run){
            System.out.printf("[monitor] [%d/%d] Active : %d, Completed : %d, Task : %d, " +
                    "isShutdown : %s , isTerminated : %s",
                    this.executor.getPoolSize(),
                    this.executor.getCorePoolSize(),
                    this.executor.getActiveCount(),
                    this.executor.getCompletedTaskCount(),
                    this.executor.getTaskCount(),
                    this.executor.isShutdown(),
                    this.executor.isTerminated());

            try {
                Thread.sleep(seconds * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
}
