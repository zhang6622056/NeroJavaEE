package sort;

/**
 * Bulle sort by java
 * Created by nero on 2018/2/28.
 */
public class Sort {


    private static void BubbleSort(int[] a){
        for(int i = a.length ; i > 0 ; --i){
            for(int j = 0 ; j < i-1 ; ++j){
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] a = new int[]{1,6,2,52,3,4,98,65,45,74};
        Sort.BubbleSort(a);

        for(int b : a){
            System.out.print(b+",");
        }
    }






}
