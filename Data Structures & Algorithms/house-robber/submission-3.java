class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        // int[] dp = new int[n];
        // Arrays.fill(dp, -1);

        // return solve(0, nums, dp);

        int[] dp = new int[n + 2];

        int next1 = 0; // dp[i + 1]
        int next2 = 0; // dp[i + 2]

        for (int i = n - 1; i >= 0; i--) {
            int robCurrent = nums[i] + next2;
            int skipCurrent = next1;

            int curr = Math.max(robCurrent, skipCurrent);

            next2 = next1;
            next1 = curr;
        }

        return next1;
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
