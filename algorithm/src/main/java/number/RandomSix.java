package number;

import java.util.Random;

/**
 * 获取6位随机数
 * Created by admin on 2018-09-05.
 */
public class RandomSix {



    private static final Random random = new Random();



    /***
     * 获取6位随机数
     * @return
     */
    public static String getRandomCodeSix(){
        int code = (random.nextInt(8)+1)*100000+
                        (random.nextInt(8)+1)*10000+
                            (random.nextInt(8)+1)*1000+
                                (random.nextInt(8)+1)*100+
                                    (random.nextInt(8)+1)*10+
                                        (random.nextInt(8)+1);
        return String.valueOf(code);
    }


    public static void main(String[] args) {
        for(int i = 0 ; i < 10 ; i++){
            System.out.println(getRandomCodeSix());
        }
    }






}
