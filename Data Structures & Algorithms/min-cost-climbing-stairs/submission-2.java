class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int[] dp = new int[n+2];
        Arrays.fill(dp, -1);

        // int startFromZero = solve(0, cost, dp);
        // int startFromOne = solve(1, cost, dp);

        // return Math.min(startFromZero, startFromOne);

        int next1 = 0;
        int next2 = 0;

        for (int i = n - 1; i >= 0; i--) {
            int curr = cost[i] + Math.min(next1, next2);

            next2=next1;
            next1=curr;
        }

        return Math.min(next1, next2);
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
