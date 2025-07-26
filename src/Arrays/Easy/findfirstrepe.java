package Arrays.Easy;

public class findfirstrepe {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1,2};
        int firstRepeat = findFirstRepeat(nums);
        System.out.println("First repeat element: " + firstRepeat);
    }

    public static int findFirstRepeat(int[] nums) {
        int[] count = new int[nums.length + 1];
        for (int num : nums) {
            count[num]++;
            if (count[num] > 1) {
                return num;
            }
        }
        return -1;
    }
}
