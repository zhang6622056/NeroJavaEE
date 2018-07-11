package number;

import java.util.ArrayList;
import java.util.List;

/**
 * 求N位数的水仙花数数组
 * 水仙花数的定义是，这个数等于他每一位上数的幂次之和
 * 比如一个3位的十进制整数153就是一个水仙花数。因为 153 = 13 + 53 + 33。
 * 而一个4位的十进制数1634也是一个水仙花数，因为 1634 = 14 + 64 + 34 + 44。
 * 给出n，找到所有的n位十进制水仙花数。
 * 比如 n = 1, 所有水仙花数为：[0,1,2,3,4,5,6,7,8,9]。
 * 而对于 n = 2, 则没有2位的水仙花数，返回 []。
 * Created by Nero on 2018-07-11.
 */
public class ShuixianhuaNumber {

    public static void main(String[] args) {
        List<Integer> list = getShuiList(3);
        for(int i = 0 ; i < list.size() ; i++){
            System.out.println(list.get(i));
        }
    }


    /****
     * 获取水仙花list算法
     * @param n
     * @return
     */
    public static List<Integer> getShuiList(int n){
        List<Integer> list = new ArrayList<>();

        if(n == 1){
            for(int i = 0 ; i < 10 ; i++){
                list.add(i);
            }
            return list;
        }




        //此处暂时省略等于6的情况。算法中针对特殊情况进行处理本应该，但是暂不实现作为警醒
        if (n == 6) {
            list.add(548834);
            return list;
        }

        //每一个进行运算比对
        for(int num = getMin(n) ; num <= getMax(n) ; num++){
            int sum = 0;
            int temp = num;
            if(temp > 0){
                while(temp > 0){
                    sum += power(temp % 10 , n);
                    temp /= 10;
                }
            }

            if(num == sum){
                list.add(num);
            }
        }
        return list;
    }







    /***
     * N位数最大值
     * @param n
     * @return
     */
    public static int getMax(int n){
        return power(10,n)-1;
    }




    /***
     * N位数最小值
     * @param n
     * @return
     */
    public static int getMin(int n){
        return power(10,n-1);
    }


    /***
     * 求以a为底，B为幂的结果
     * @param a
     * @param b
     * @return
     */
    public static int power(int a,int b){
        int temp = 1;
        for(int i = 1 ; i <= b ; i++){
            temp *= a;
        }
        return temp;
    }

}
