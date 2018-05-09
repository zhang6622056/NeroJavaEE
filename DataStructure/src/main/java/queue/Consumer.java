package queue;

import java.util.concurrent.BlockingQueue;

/**
 *
 * Created by Nero on 2018-05-08.
 */
public class Consumer implements Runnable{

    public static BlockingQueue queue;

    public Consumer(BlockingQueue blockingQueue) {
        queue = blockingQueue;
    }

    @Override
    public void run() {
        Object obj = queue.poll();
        System.out.println(obj+"name:"+Thread.currentThread().getName()+"hashcode:"+queue.hashCode());
    }
}
