package bitcalculate;

/**
 * 二进制加法，当进位为0时表示相加完毕
 * ^ 为相加   & 《《 为进位。
 * 然后结果再次进行相加和进位查询，当进位为0则表示为最终结果
 * Created by admin on 2018-07-18.
 */
public class Bitadd {


    public static void main(String[] args) {
        int a = 1;
        int b = 1;

        int ans = 0;
        while(b != 0){
            //加法运算
            ans = a ^ b;
            //进位运算。
            b = (a&b) << 1;
            a = ans;
        }

        System.out.println(ans);


    }






}
