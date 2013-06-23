package iview.lock;

/**
 * Created by IntelliJ IDEA.
 * User: ojha
 * Date: 6/21/13
 * Time: 9:49 AM
 */
public class Counter {
    private Lock lock = new Lock();
    private int count = 0;

    public int inc(){
        int newCount = 0;
        try {
            lock.lock();
            newCount = ++count;
            lock.unlock();

        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return newCount;
    }
}
