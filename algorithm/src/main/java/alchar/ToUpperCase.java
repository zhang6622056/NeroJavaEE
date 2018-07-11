package alchar;

/**
 * Created by admin on 2018-07-11.
 */
public class ToUpperCase {


    public static void main(String[] args) {
        System.out.println(toUpperCaseString("abc85e52f"));
    }


    /***
     * char 转大写char
     * 相差32个字符
     * @param lower
     * @return
     */
    public static char toUpperCase(char lower){
        return (char)(lower-32);
    }


    /****
     * String 转upper case
     * 相差32个字符，ToCharArray
     * @param parameter
     * @return
     */
    public static String toUpperCaseString(String parameter){
        char[] pa = parameter.toCharArray();
        char[] res = new char[pa.length];
        for(int i = 0 ; i < pa.length ; i++){
            if(pa[i] >= 97 && pa[i] <= 122){
                res[i] = (char)(pa[i]-32);
            }else{
                res[i] = pa[i];
            }
        }
        return new String(res);
    }








}
