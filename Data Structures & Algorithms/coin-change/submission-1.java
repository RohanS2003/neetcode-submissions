class Solution {
    public int coinChange(int[] coins, int amount) {
        int large = amount + 1;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, large);

        dp[0] = 0;

        for (int currAmount = 1; currAmount <= amount; currAmount++) {
            for (int coin : coins) {
                if (currAmount - coin >= 0) {
                    int previousAmount = currAmount - coin;

                    if (dp[previousAmount] != large) {
                        dp[currAmount] = Math.min(
                            dp[currAmount],
                            1 + dp[previousAmount]
                        );
                    }
                }
            }
        }

        if (dp[amount] == large) {
            return -1;
        }

        return dp[amount];
    }

    private int solve(int[] coins, int amount, int[] dp) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[amount] != -1) {
            return dp[amount];
        }

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            int remainingAnswer = solve(coins, amount - coin, dp);

            if (remainingAnswer != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, 1 + remainingAnswer);
            }
        }

        dp[amount] = minCoins;

        return dp[amount];
    }
}
