package algs.leet;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] ints = twoSum.twoSum(new int[]{3,2,4}, 6);
        for (int anInt : ints) {
            System.out.print(anInt+ ", ");
        }
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
