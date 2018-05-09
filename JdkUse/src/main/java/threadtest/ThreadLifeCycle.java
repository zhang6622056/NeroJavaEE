package threadtest;

/**
 * 线程声明周期
 * Created by Nero on 2018-05-08.
 */
public class ThreadLifeCycle {

    public static void main(String[] args) throws InterruptedException {
       Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run......");
                try {
                    Thread.currentThread().sleep(5000);

                    //如果检测线程状态，那么可打开下面语句看jvm线程情况
//                    while(true){
//
//                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"THREAD NERO");

        //STATE NEW
        System.out.println("thread state:"+thread.getState());
        thread.start();

        //TIMED_WAITING
        thread.sleep(2000);
        System.out.println("thread state:"+thread.getState());

        //RUNNABLE
        thread.sleep(4000);
        System.out.println("thread state:"+thread.getState());


        while(true){

        }


    }












}
