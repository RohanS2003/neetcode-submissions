class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] front1 = new int[2]; // dp[day + 1]
        int[] front2 = new int[2]; // dp[day + 2]

        for (int day = n - 1; day >= 0; day--) {
            int[] curr = new int[2];

            curr[1] = Math.max(
                -prices[day] + front1[0],
                front1[1]
            );

            curr[0] = Math.max(
                prices[day] + front2[1],
                front1[0]
            );

            front2 = front1;
            front1 = curr;
        }

        return front1[1];
    }
}