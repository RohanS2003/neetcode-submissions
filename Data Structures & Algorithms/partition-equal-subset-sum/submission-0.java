class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;

        for (int num : nums) {
            total += num;
        }

        if (total % 2 != 0) {
            return false;
        }

        int target = total / 2;
        int n = nums.length;

        boolean[][] dp = new boolean[n + 1][target + 1];

        // Base case: target 0 is always possible
        for (int index = 0; index <= n; index++) {
            dp[index][0] = true;
        }

        for (int index = n - 1; index >= 0; index--) {
            for (int sum = 1; sum <= target; sum++) {
                boolean skip = dp[index + 1][sum];

                boolean take = false;
                if (nums[index] <= sum) {
                    take = dp[index + 1][sum - nums[index]];
                }

                dp[index][sum] = take || skip;
            }
        }

        return dp[0][target];
    }
}