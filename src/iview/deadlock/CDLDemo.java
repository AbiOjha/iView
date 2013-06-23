package iview.deadlock;

import java.util.concurrent.CountDownLatch;

/**
 * Created by IntelliJ IDEA.
 * User: ojha
 * Date: 6/17/13
 * Time: 3:40 AM
 */
public class CDLDemo {
    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(5);
        System.out.println("Starting");

        new Thread(new MyThread(cdl, "A")).start();
        new Thread(new MyThread(cdl, "B")).start();
        new Thread(new MyThread(cdl, "C")).start();

        try {
            cdl.await();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Done..");
    }
}

class MyThread implements Runnable{

    CountDownLatch latch;
    String name;


    MyThread(CountDownLatch latch, String name) {
        this.latch = latch;
        this.name = name;
        new Thread(this);
    }

    @Override
    public void run() {
        for (int i=0; i < 5; i++){
            System.out.println(name +" : " +i);
            latch.countDown();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

    }
}
