package iview.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by IntelliJ IDEA.
 * User: ojha
 * Date: 6/17/13
 * Time: 7:45 PM
 */
public class LockDemo {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        new LockThread("A", lock);
        new LockThread("B", lock);
    }
}

// shared resource
class Shared{
    static int count = 0;
}

class LockThread implements Runnable{

    String name;
    Lock lock;

    LockThread(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Starting..");
        // first lock count
        try {
            System.out.println(name + " is waiting to lock count.");
            lock.lock();
            System.out.println(name + " locking count");
            Shared.count++;
            System.out.println(name + " : " + Shared.count);

            // now allow a context switch
            System.out.println(name + " is sleeping");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        } finally {
            //unlock
            System.out.println(name + " is unlocking count.");
            lock.unlock();
        }
    }
}
