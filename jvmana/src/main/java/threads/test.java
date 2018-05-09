package threads;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by admin on 2018/2/9.
 */
public class test {



    public static void main(String[] args) throws InterruptedException {
        //注意是byte基本类型。如果是包装类将会超出
        List<byte[]> list = new ArrayList<byte[]>();
        int i = 0 ;
        Thread.sleep(20000000);  //设置休眠频率以便于观察JVM
        while(true){
            Thread.sleep(20000);  //设置休眠频率以便于观察JVM
            list.add(new byte[1024*1024*6]);
            System.out.println(i++);
        }
    }
}
