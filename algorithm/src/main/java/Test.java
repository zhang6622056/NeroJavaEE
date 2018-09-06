import java.util.ArrayList;

/**
 *
 * Created by Nero on 2018-07-12.
 */
public class Test {


    public static void main(String[] args) {
        String a = "adsjkfljdkls1uqweuoqiwuoi 5uiouiouioaadjfljkasdjfkljkl";
        String b = a.substring(0,getChar(a));
        System.out.println(b);
    }


    public static int getChar(String a){
        for(int i = a.length()-1 ; i > 0; i--){
            if(a.charAt(i) - 0 == 32){
                return i;
            }
        }
        return a.length();
    }







}
