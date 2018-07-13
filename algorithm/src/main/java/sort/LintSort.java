package sort;

/**
 * Created by admin on 2018-07-12.
 */
public class LintSort {



    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers(int[] A) {
        for (int i = 0 ; i < A.length-1 ; i++ ){
            for(int j = i ; j < A.length-i-1 ; j++){
                if(A[j] > A[j+1]){
                    compareAndSwap(A,A[j],A[j+1]);
                }
            }
        }
    }



    public static void compareAndSwap(int[] A,int a,int b){
        int temp = b;
        b = a;
        a = temp;
    }

}
