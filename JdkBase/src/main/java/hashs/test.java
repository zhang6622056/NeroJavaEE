package hashs;

/**
 * Created by admin on 2018/2/27.
 */
public class test {

    public static void main(String[] args) {
        NeroMap<String,Object> neroMap = new NeroMap<>();
        neroMap.put("key","123");

        System.out.println(neroMap.size());
    }




    public static int get(int number){
        int rounded = number >= Integer.MAX_VALUE
                ? Integer.MAX_VALUE
                : (rounded = Integer.highestOneBit(number)) != 0
                ? (Integer.bitCount(number) > 1) ? rounded << 1 : rounded
                : 1;

        return rounded;
    }




}
