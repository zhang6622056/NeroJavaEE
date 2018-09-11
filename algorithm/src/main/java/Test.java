import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * Created by Nero on 2018-07-12.
 */
public class Test {


    public static void main(String[] args) {
        System.out.println(solveMeFirst(2,3));
    }


    static int solveMeFirst(int a, int b) {
        // Hint: Type return a+b; below
        while(b != 0){
            int sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return a;
    }






}
