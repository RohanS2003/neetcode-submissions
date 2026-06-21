class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[] next = new int[amount + 1];

        next[0] = 1;

        for (int index = n - 1; index >= 0; index--) {
            int[] curr = new int[amount + 1];

            curr[0] = 1;

            for (int currAmount = 1; currAmount <= amount; currAmount++) {
                int take = 0;

                if (currAmount - coins[index] >= 0) {
                    take = curr[currAmount - coins[index]];
                }

                int skip = next[currAmount];

                curr[currAmount] = take + skip;
            }

            next = curr;
        }

        return next[amount];
    }
}