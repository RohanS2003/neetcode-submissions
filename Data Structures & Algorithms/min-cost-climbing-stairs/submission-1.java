class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int[] dp = new int[n+2];
        Arrays.fill(dp, -1);

        // int startFromZero = solve(0, cost, dp);
        // int startFromOne = solve(1, cost, dp);

        // return Math.min(startFromZero, startFromOne);

        dp[n] = 0;
        dp[n + 1] = 0;

        for (int i = n - 1; i >= 0; i--) {
            int oneStep = dp[i + 1];
            int twoSteps = dp[i + 2];

            dp[i] = cost[i] + Math.min(oneStep, twoSteps);
        }

        return Math.min(dp[0], dp[1]);
    }

    private int solve(int i, int[] cost, int[] dp) {
        if (i >= cost.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int oneStep = solve(i + 1, cost, dp);
        int twoSteps = solve(i + 2, cost, dp);

        dp[i] = cost[i] + Math.min(oneStep, twoSteps);

        return dp[i];
    }
}
