package concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {



    public static final int threadNumber = 10000;


    public static void main(String[] args) throws InterruptedException {

        final CountDownLatch countDownLatch = new CountDownLatch(threadNumber);

        for(int i = 0 ; i < threadNumber ; i++){
            new Thread(new Runnable() {
                public void run() {
                    String name = Thread.currentThread().getName();
                    try {
                        System.out.println(name+"线程ready");

                        //子线程等待
                        countDownLatch.await();
                        System.out.println("start run.... name:"+name);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();



            if(i < threadNumber -1 ){
                //countdownlatch主线程计数器-1
                countDownLatch.countDown();
            }

        }


        Thread.sleep(5000);

        countDownLatch.countDown();

    }



}
