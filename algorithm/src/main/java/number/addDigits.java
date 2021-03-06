package number;

//给出一个非负整数 num，反复的将所有位上的数字相加，直到得到一个一位的整数。
//
//        样例
//        给出 num = 38。
//
//        相加的过程如下：3 + 8 = 11，1 + 1 = 2。因为 2 只剩下一个数字，所以返回 2。

/*****
 * 问题的本质，在于上限和取余。 个位数相加的上限是9.  那么任意数对9取余，数只可能小于9
 *  12对9取余结果为3 正好等于1+2
 *  121 对9 取余结果为4   正好等于 1+2+1
 *  就像这个规律并不是必然的因为 1-9 是一个循环。   相对应10-18 也是一个1-9.
 *  19则为1。
 *  转换思想式子  为若干个9相乘得到一个整数。
 *  而如果得到小于9的个位数。就是取余了。
 *  但是对于9的倍数，取余为0.但是9的倍数出来是多少呢？
 *  类似于81%9 = 0 . 但是 8+1 = 9。所以除尽的情况下。结果返回9即可。
 *  但是在小于等于9的个位情况下直接返回即可。
 */
public class AddDigits {


    public static void main(String[] args) {
        System.out.println(-1 % 9);
    }


    /**
     * @param num: a non-negative integer
     * @return: one digit
     */
    public int addDigits(int num) {
        if(num <= 9){
            return num;
        }
        int res = num % 9;
        if(res == 0){
            res = 9;
        }
        return res;
    }




}
