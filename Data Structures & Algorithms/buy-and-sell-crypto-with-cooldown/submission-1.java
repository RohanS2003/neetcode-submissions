class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n][2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 1, prices, dp);
    }

    private int solve(int day, int canBuy, int[] prices, int[][] dp) {
        if (day >= prices.length) {
            return 0;
        }

        if (dp[day][canBuy] != -1) {
            return dp[day][canBuy];
        }

        if (canBuy == 1) {
            int buy = -prices[day] + solve(day + 1, 0, prices, dp);
            int skip = solve(day + 1, 1, prices, dp);

            dp[day][canBuy] = Math.max(buy, skip);
        } else {
            int sell = prices[day] + solve(day + 2, 1, prices, dp);
            int skip = solve(day + 1, 0, prices, dp);

            dp[day][canBuy] = Math.max(sell, skip);
        }

        return dp[day][canBuy];
    }
}