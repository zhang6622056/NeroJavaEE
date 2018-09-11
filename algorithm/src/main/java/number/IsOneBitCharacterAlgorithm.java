package number;

/**
 * 给定bit数组有三种情况 11 10 或者1,0
 * -结尾必须为0或1，但不能为两位的10或者11.
 * 结尾必须为单个的0或者1
 * bits = [1, 0, 0]
 *  Output: True
 *
 * bits = [1, 1, 1, 0]
 * Output: False
 *
 *
 * Created by admin on 2018-09-06.
 */
public class IsOneBitCharacterAlgorithm {

    public static boolean isOneBitCharacter(int[] bits) {
        if(bits.length == 0) return false;

        for(int i = 0 ; i < bits.length ; i++){
            if((bits[i]&1) == 1){
                if(i+1 == bits.length -1){
                    return false;
                }else{
                    i++;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[] a = new int[]{1};
        System.out.println(isOneBitCharacter(a));
    }







}
