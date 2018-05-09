package queue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by admin on 2018-05-08.
 */
public class Producer implements Runnable{

    public static BlockingQueue QUEUE = null;
    public static Object inputObject = null;


    public Producer(BlockingQueue blockingQueue,Object obj) {
        QUEUE = blockingQueue;
        inputObject =obj;
    }


    @Override
    public void run() {
        try {
            QUEUE.put(inputObject);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
