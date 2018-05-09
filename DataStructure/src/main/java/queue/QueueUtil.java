package queue;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 队列使用
 * 阻塞队列使用场景：
 * 1-搭配数据库进行ID预初始化
 *
 * Created by Nero on 2018-05-07.
 */
public class QueueUtil {

    private final static BlockingQueue<String> queue = new LinkedBlockingQueue<String>(200);

    public static void put(Object obj){
        Thread thread = new Thread(new Producer(queue,obj),"producer"+UUID.randomUUID().toString().substring(0,4));
        thread.start();
        System.out.println("put state:"+thread.getState());
    }


    public static void poll(){
        Thread thread = new Thread(new Consumer(queue),"consumer"+UUID.randomUUID().toString().substring(0,4));
        thread.start();
        System.out.println("poll state:"+thread.getState());
    }




    public static void main(String[] args) throws InterruptedException {
        while(true){
            String key = UUID.randomUUID().toString();
            String key1 = UUID.randomUUID().toString();
            put(key);
            put(key1);
            Thread.sleep(2000);
            poll();
        }
    }

}
