package number;

/**
 * 反转一个3位数 比如123，期望得到321
 * Created by Nero on 2018-07-10.
 */
public class ReverseNumber {



    public static void main(String[] args) {
        String a = "a";
        System.out.println(a.toUpperCase());
    }

    //反转一个三位数 789 -> 987
    public static Integer doReverse(int number){
        int first = number / 100;
        int second = number / 10 % 10;
        int third = number % 100 % 10;
        return third * 100 + second * 10 + first;
    }
}
