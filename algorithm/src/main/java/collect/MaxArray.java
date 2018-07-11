package collect;

/**
 * 求一个数组中的最大值
 * Created by admin on 2018-07-11.
 */
public class MaxArray {

    public static void main(String[] args) {
       // maxOfArray()
    }


    public static float maxOfArray(float[] A) {
        float curmax = A[0];
        for(int i = 1 ; i < A.length ; i++){
            curmax = curmax > A[i] ? curmax : A[i];
        }
        return curmax;
    }

}
