package only;

import java.util.ArrayList;
import java.util.List;

/**
 * 素数类
 * Created by Nero on 2017/12/7.
 */
public class PrimeNumber {

    private List<Integer> primeList = new ArrayList<>();

    private static PrimeNumber primeNumber;

    private PrimeNumber(){};

    public static PrimeNumber getInstance(){
        if(null == primeNumber){
            primeNumber = new PrimeNumber();
        }
        return primeNumber;
    }

    /***
     * 求N下面的最大质数
     * @param n
     * @return
     */
    public int maxPrime(int n){
        boolean again = true;
        int maxNumber = 0;
        for(int number = n-1; again ; number--){
            if(is2n(number)){
                continue;
            }
            boolean isp = true;
            for(int j = 3 ; j < number ; j ++){
                if(number % j == 0) {
                    isp = false;
                    break;
                }
            }
            if(isp){
                again = false;
                maxNumber = number;
            }
        }
        return maxNumber;
    }



    /**
     * 判断一个数是否为偶数
     * @param number
     * @return
     */
    private boolean is2n(int number){
        return number%2 == 0 ? true : false;
    }

    /***
     * 是否为奇数
     * @param number
     * @return
     */
    private boolean isodd(int number){
        return number%2 == 0 ? false : true;
    }


    public static void main(String[] args) {
        PrimeNumber primeNumber = PrimeNumber.getInstance();
        System.out.println(primeNumber.maxPrime(1024));
    }

}
