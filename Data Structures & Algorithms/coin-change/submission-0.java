class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);

        int answer = solve(coins, amount, dp);

        if (answer == Integer.MAX_VALUE) {
            return -1;
        }

        return answer;
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
