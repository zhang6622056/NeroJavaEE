package queue.demo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by admin on 2018-05-09.
 */
public class BlockingQueueDemo {



    public static final int number = 200;


    public static void main(String[] args) {
        BlockingQueue blockingQueue = new LinkedBlockingDeque<>(number);

        while(true){
            blockingQueue.add("a");
            System.out.println(blockingQueue.size());
        }

    }



}
