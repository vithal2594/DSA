package Arrayss.Easy;

public class oddOcc {
    public static void main(String[] args) {
        int [] nums={2,2,1,1,1,2,2};
        System.out.println(findOdd(nums));
    }
    public static int findOdd(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result ^= num; // XOR each number with the result
        }
        return result;
    }
}
