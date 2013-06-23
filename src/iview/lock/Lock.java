package iview.lock;

/**
 * Created by IntelliJ IDEA.
 * User: ojha
 * Date: 6/21/13
 * Time: 9:49 AM
 */
public class Lock {
    private boolean isLocked = false;

    public synchronized void lock() throws InterruptedException {
        while (isLocked){
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock(){
        isLocked = false;
        notify();
    }
}
