package number;

/**
 * Created by admin on 2018-07-10.
 */
public class ReverseNumber {

    private static int a = 586;

    public static void main(String[] args) {
        System.out.println(doReverse("586"));
    }



    public static String doReverse(String number){
        String a = number;
        char f = a.charAt(2);
        char s = a.charAt(1);
        char t = a.charAt(0);

        return new String(new char[]{f,s,t});
    }









}
