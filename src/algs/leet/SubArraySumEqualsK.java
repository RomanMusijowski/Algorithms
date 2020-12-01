package algs.leet;

public class SubArraySumEqualsK {

    public static void main(String[] args) {
        SubArraySumEqualsK obj = new SubArraySumEqualsK();
        int i = obj.subarraySum(new int[]{1, -1, 0}, 0);
        System.out.println(i);
    }

    public int subarraySum(int[] nums, int k) {

        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;

            for (int i1 = i; i1 < nums.length; i1++) {
                sum+= nums[i1];

                if (sum == k) {
                    result++;
                }
            }
        }
        return result;
    }
}
