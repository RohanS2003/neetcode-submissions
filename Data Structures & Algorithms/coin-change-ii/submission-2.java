class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

       int[][] dp = new int[n + 1][amount + 1];

        for (int index = 0; index <= n; index++) {
            dp[index][0] = 1;
        }

        for (int index = n - 1; index >= 0; index--) {
            for (int currAmount = 1; currAmount <= amount; currAmount++) {
                int take = 0;

                if (currAmount - coins[index] >= 0) {
                    take = dp[index][currAmount - coins[index]];
                }

                int skip = dp[index + 1][currAmount];

                dp[index][currAmount] = take + skip;
            }
        }

        return dp[0][amount];
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