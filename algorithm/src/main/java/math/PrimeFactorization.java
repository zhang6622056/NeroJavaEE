package math;

import java.util.ArrayList;
import java.util.List;

//235. 分解质因数
//        将一个整数分解为若干质因数之乘积
//
//        样例
//        给出 10, 返回 [2, 5].
//
//        给出 660, 返回 [2, 2, 3, 5, 11].
public class PrimeFactorization {


    public static void main(String[] args) {
        List<Integer> a = getPrimeMinToMax(9409);
        for(int b : a){
            System.out.println(b);
        }
    }


    /***
     * 每次除尽，都重新赋值除数num
     * @return
     */
    public static List<Integer> getPrimeMinToMax(int num){
        //获取平方根，为循环上限
        int a = (int)Math.sqrt(num);
        List<Integer> res = new ArrayList<>();

        //每次进行替换num
        for(int i = 2 ; i <= a ; i++){
            while(num % i == 0){
                res.add(i);
                num = num / i ;
            }
        }

        //如果最后不为1则说明是最后的质数乘积
        if(num != 1){
            res.add(num);
        }
        return res;
    }

}
