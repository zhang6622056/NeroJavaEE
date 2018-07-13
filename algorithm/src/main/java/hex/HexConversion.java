package hex;

import java.util.ArrayList;
import java.util.List;

/**
 * 进制转换
 * Created by Nero on 2018-07-12.
 */
public class HexConversion {


    public static void main(String[] args) {
        System.out.println(hexConversion(30,16));
    }



    /***
     * n十进制数
     * k 目标进制 16 >=k >= 2
     * @param n
     * @param k
     * @return
     */
    public static String hexConversion(int n,int k){
        if(k == 10) return String.valueOf(n);
         if(n < k && k < 10){
             return String.valueOf(k);
        }

        //获取正向余数list
        List<Integer> list = getListMod(n,k);

        //逆向余数组装string
        StringBuffer sb = new StringBuffer();
        for(int i = list.size()-1 ; i >= 0 ; i--){
            int cur = list.get(i);
            if(cur > 9){
                sb.append(getStringUp9(String.valueOf(cur)));
            }else{
                sb.append(cur);
            }
        }
        return sb.toString();
    }


    /***
     * 获取正向余数list
     * @return
     */
    public static List<Integer> getListMod(int n,int k){
        List<Integer> list = new ArrayList<>();
        while(n/k != 0){
            list.add(n%k);
            n = n/k;
        }
        list.add(n%k);
        return list;
    }




    /***
     * 9以上数字转换。
     * @param num
     * @return
     */
    public static String getStringUp9(String num){
        String res = "";
        switch (num){
            case "10" :
               res = "A";
               break;
            case "11" :
                res = "B";
                break;
            case "12" :
                res = "C";
                break;
            case "13" :
                res = "D";
                break;
            case "14" :
                res = "E";
                break;
            case "15" :
                res = "F";
                break;
        }
        return res;
    }
















}
