package iview.deadlock;

import java.util.concurrent.BlockingQueue;

public class ThreadPool {
}

class PoolThread extends Thread{
    private BlockingQueue<Runnable> taskQueue = null;
    private boolean isStopped = false;

    public PoolThread(BlockingQueue queue) {this.taskQueue = queue;}
    public void run(){
        while(!isStopped){
            Runnable runnable = taskQueue.poll();
        }
    }
}
