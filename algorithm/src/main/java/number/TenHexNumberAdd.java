package number;

/**
 * Created by admin on 2018-07-24.
 */
public class TenHexNumberAdd {


    public static void main(String[] args) {
        toaddNumber("123","45");
    }


    public static String toaddNumber(String num1,String num2){

        if(num1 == null || "0".equals(num1)) return num2;
        if(num2 == null || "0".equals(num2)) return num1;


        String r1 = new StringBuffer(num1).reverse().toString();
        String r2 = new StringBuffer(num2).reverse().toString();

        int len = r1.length() > r2.length() ? r1.length() : r2.length();

        StringBuffer res = new StringBuffer();
        int cou = 0;
        for(int i = 0 ; i < len ; i++){
            if(r1.length() > i){
                cou += r1.charAt(i) - '0';
            }
            if(r2.length() > i){
                cou += r2.charAt(i) - '0';
            }
            res.append(cou % 10);
            cou = cou / 10;
        }
        if(cou != 0){
            res.append(cou);
        }
        return res.reverse().toString();
    }







}
