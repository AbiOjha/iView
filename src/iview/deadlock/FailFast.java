package iview.deadlock;

import java.util.*;

class Modify implements Runnable{

    Map<String, String> map;

    Modify(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        map.put("odisha", "bbsr");
        System.out.println("Thread updated");
    }
}
public class FailFast {
    public static void main(String[] args) throws InterruptedException {
        Map<String, String> map = new HashMap<String, String>();
        map.put("india", "delhi");
        //Collection<String> collection = new ArrayList<String>();
        Set<String> keyset = map.keySet();
        Iterator<String> it = keyset.iterator();
        map.put("india", "ctc");


        System.out.println("New Object added");
        while (it.hasNext()){
            new Thread(new Modify(map)).start();
            Thread.sleep(500);
            System.out.println(map.get(it.next()));
        }
    }

}
