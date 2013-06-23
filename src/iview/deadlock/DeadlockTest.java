package iview.deadlock;

/**
 * Created by IntelliJ IDEA.
 * User: ojha
 * Date: 6/11/13
 * Time: 11:47 PM
 */
public class DeadlockTest extends Thread{

    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public void method1(){
        synchronized (lock1){
            delay(500);
            System.out.println("Method1 : " + Thread.currentThread().getName());
            synchronized (lock2){
                System.out.println("Method1 executing...");
            }
        }
    }

    public void method2(){
        synchronized (lock2){
            delay(500);
            System.out.println("Method2 : " + Thread.currentThread().getName());
            synchronized (lock1){
                System.out.println("Method2 executing...");
            }
        }
    }

    public void delay(long timeInMillis){
        try {
            Thread.sleep(timeInMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
    @Override
    public void run() {
        method1();
        method2();
    }

    public static void main(String[] args) {
        DeadlockTest thread1 = new DeadlockTest();
        DeadlockTest thread2 = new DeadlockTest();

        thread1.start();
        thread2.start();
    }
}
