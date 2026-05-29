class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        int excludeLast = solve(0, n - 2, nums, dp1);
        int excludeFirst = solve(1, n - 1, nums, dp2);

        return Math.max(excludeLast, excludeFirst);
    }

    private int solve(int i, int end, int[] nums, int [] dp) {
        if (i > end) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int robCurrent = nums[i] + solve(i + 2, end, nums, dp);
        int skipCurrent = solve(i + 1, end, nums, dp);

        dp[i] = Math.max(robCurrent, skipCurrent);

        return dp[i];
    }
}
