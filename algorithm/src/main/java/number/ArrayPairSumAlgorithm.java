package number;

//-排序
//-相邻为数组相加
//Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
//
//        样例
//        Input: [1,4,3,2]
//
//        Output: 4
//        Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).


public class ArrayPairSumAlgorithm {

    public static int arrayPairSum(int[] nums) {
        if(nums.length == 2) return nums[0] < nums[1] ? nums[0] : nums[1];

        int[] res = sort(nums);
        int finalres = 0;
        for(int i = 0 ; i < res.length ; i = i+2){
            finalres+=res[i];
        }
        return finalres;
    }


    //冒泡排序
    private static int[] sort(int[] nums){
        for(int i = 0 ; i < nums.length ; i++){
            for(int j = 0 ; j < nums.length-(i+1); j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }

        return nums;
    }


    public static void main(String[] args) {
        int[] a = new int[]{7,3,1,0,0,6};

        System.out.println(arrayPairSum(a));
    }




}
