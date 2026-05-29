class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(0, nums, dp);
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
