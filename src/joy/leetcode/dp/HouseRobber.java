package joy.leetcode.dp;


// 所有DP问题的解法的通用进化路径：https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
public class HouseRobber {
    // 一个错误的观念是，把所有奇数位置上的数和 所有偶数位置上的数和，取最大的。
    // 例：[2, 1, 1, 6], 按照上面的算法，最大的值为7=1+6，但实际是2 + 8

    public int rob1(int[] nums) {
        // dp: top to down, 有很多重复计算。时间复杂度：O(2**n)
        return rob1(nums, nums.length - 1);
    }
    private int rob1(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        return Math.max(rob1(nums, i - 2) + nums[i], rob1(nums, i - 1));
    }

    public int rob2(int[] nums) {
        // dp: top to down, 消除rob的重复计算。时间复杂度为O(n)
        return rob2(nums, nums.length - 1);
    }
    private int rob2(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        return Math.max(rob2(nums, i - 2) + nums[i], rob2(nums, i - 1));
    }

    public int rob3(int[] nums) {
        // dp: down to top， 消除递归。（但是此时就不太复合直觉了)
        if (nums.length == 0) return 0;
        int[] memo = new int[nums.length + 1];
        memo[0] = 0;
        memo[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            memo[i+1] = Math.max(memo[i], memo[i-1] + val);
        }
        return memo[nums.length];
    }

    public int rob5(int[] nums) {
        // dp: bottom-op, use two variable
        if (nums.length == 0) return 0;
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = tmp;
        }
        return prev1;
    }


}
