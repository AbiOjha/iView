package iview.deadlock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by IntelliJ IDEA.
 * User: ojha
 * Date: 6/17/13
 * Time: 1:29 AM
 */
public class MyArrayBlockingQueue {
    BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(10,true);

    String getData(){
        return blockingQueue.poll();
    }

    public void setData(String e){
        blockingQueue.add(e);
    }

    public static void main(String[] args) {
        final MyArrayBlockingQueue queue = new MyArrayBlockingQueue();

        for (String s : queue.blockingQueue){
            System.out.println(s);
        }

        //Data producer
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10; i++){
                    queue.setData(String.valueOf(i));
                }
            }
        }).start();

        //Data Comsumer
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10; i++){
                    System.out.println(queue.getData());
                }
            }
        }).start();
    }
}
