package hex;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nero on 2018-07-19.
 */
public class AddToBinary {

    /***
     * 二进制相加，用二进制表示
     * 1-颠倒顺序
     * 2-char - ‘0’ 转换int 。 并相加。每次将进位赋值给count即可
     * @param args
     */
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";

        int len = a.length() > b.length() ? a.length() : b.length();
        String ar = new StringBuffer(a).reverse().toString();
        String br = new StringBuffer(b).reverse().toString();

        int count = 0;
        StringBuffer res = new StringBuffer();
        for(int i = 0 ; i < len ; i++){
            if(i < a.length()){
                count += (ar.charAt(i) - '0');
            }
            if(i < b.length()){
                count += (br.charAt(i) - '0');
            }
            res.append(count % 2);
            count = count / 2;
        }
        if(count != 0){
            res.append(count);
        }
        System.out.println(res.reverse().toString());
    }


}
