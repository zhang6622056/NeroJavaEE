package threads;

/**
 * Created by admin on 2018/2/8.
 */
public class ThreadA implements Runnable{


    @Override
    public void run() {

    }


    public static void main(String[] args) throws InterruptedException {
        int a = 0;
        while(a < 100000){
            new Thread().start();
            new Thread().start();
            new Thread().start();
            new Thread().start();
            new Thread().start();
            a = a+5;
            Thread.sleep(1000);
            System.out.println(a);
        }




    }


}
