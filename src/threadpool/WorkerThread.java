package threadpool;

/**
 * Created by IntelliJ IDEA.
 * User: ojha
 * Date: 6/18/13
 * Time: 11:24 AM
 *
 * The workerthread class
 */
public class WorkerThread implements Runnable {
    private final String command;

    public WorkerThread(final String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Command = " + command);
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End ");
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
