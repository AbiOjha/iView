package iview.deadlock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by IntelliJ IDEA.
 * User: ojha
 * Date: 6/17/13
 * Time: 2:48 PM
 */
public class BarDemo {
    public static void main(String[] args) {
        CyclicBarrier cbar = new CyclicBarrier(3, new BarAction() );
        System.out.println("Starting");

        new MyCyclicThread(cbar, "A");
        new MyCyclicThread(cbar, "B");
        new MyCyclicThread(cbar, "C");

        new MyCyclicThread(cbar, "D");
        new MyCyclicThread(cbar, "E");
        new MyCyclicThread(cbar, "F");
    }
}

// Thread that uses cyclic barrier
class MyCyclicThread implements Runnable{

    CyclicBarrier cbar;
    String name;

    MyCyclicThread(CyclicBarrier cbar,String name) {
        this.cbar = cbar;
        this.name = name;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println(name);
        try {
            cbar.await();
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (BrokenBarrierException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        System.out.println("Wait Finish " + name);
    }
}
// object called when cyclic barrier ends
class BarAction implements Runnable{

    @Override
    public void run() {
        System.out.println("Barrier Reached!");
    }
}
