class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, amount, coins, dp);
    }

    private int solve(int index, int amount, int[] coins, int[][] dp) {
        if (amount == 0) {
            return 1;
        }

        if (index == coins.length) {
            return 0;
        }

        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        int take = 0;

        if (amount - coins[index] >= 0) {
            take = solve(index, amount - coins[index], coins, dp);
        }

        int skip = solve(index + 1, amount, coins, dp);

        dp[index][amount] = take + skip;

        return dp[index][amount];
    }
}