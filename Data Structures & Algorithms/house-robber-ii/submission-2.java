class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int excludeLast = robLinear(nums, 0, n - 2);
        int excludeFirst = robLinear(nums, 1, n - 1);

        return Math.max(excludeLast, excludeFirst);
    }

    private int robLinear(int[] nums, int start, int end) {
        int n = nums.length;
        int[] dp = new int[n + 2];

        for (int i = end; i >= start; i--) {
            int robCurrent = nums[i] + dp[i + 2];
            int skipCurrent = dp[i + 1];

            dp[i] = Math.max(robCurrent, skipCurrent);
        }

        return dp[start];
    }
}
