class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        // int[] dp = new int[n];
        // Arrays.fill(dp, -1);

        // return solve(0, nums, dp);

        int[] dp = new int[n + 2];

        dp[n] = 0;
        dp[n + 1] = 0;

        for (int i = n - 1; i >= 0; i--) {
            int robCurrent = nums[i] + dp[i + 2];
            int skipCurrent = dp[i + 1];

            dp[i] = Math.max(robCurrent, skipCurrent);
        }

        return dp[0];
    }

    private int solve(int i, int[] nums, int[] dp) {
        if (i >= nums.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int robCurrent = nums[i] + solve(i + 2, nums, dp);
        int skipCurrent = solve(i + 1, nums, dp);

        dp[i] = Math.max(robCurrent, skipCurrent);

        return dp[i];
    }
}
