package joy.leetcode.dp;

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        // f[i], maxSubArrayEndingHere
        // f[i+1] = f[i]+nums[i+1] > f[i] ? f[i]+nums[i+1] : nums[i]
        int maxSoFar=nums[0], maxEndingHere=nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(maxEndingHere+nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] nums = {-6, -5, -4, -3, -2, -1};
        System.out.println(MaximumSubarray.maxSubArray(nums));
    }


}
