package threads;

/**
 * Created by admin on 2018/2/13.
 */
public class MethodArea {


    public static char[] a = new char[1024*1024*6];
  //  public static char[] b = new char[1024*1024*6];
    public static void main(String[] args) throws InterruptedException {
        System.out.println(a.length);
        Thread.sleep(200000);
    }



}
