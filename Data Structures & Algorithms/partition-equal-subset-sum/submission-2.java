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

        //boolean[][] dp = new boolean[n + 1][target + 1];
        boolean[] next = new boolean[target + 1];
        boolean[] curr = new boolean[target + 1];

        // Base case: target 0 is always possible
        // for (int index = 0; index <= n; index++) {
        //     dp[index][0] = true;
        // }

        next[0]=true;

        for (int index = n - 1; index >= 0; index--) {
            curr = new boolean[target + 1];
            for (int sum = 1; sum <= target; sum++) {
                boolean skip = next[sum];

                boolean take = false;
                if (nums[index] <= sum) {
                    take = next[sum - nums[index]];
                }

                curr[sum] = take || skip;
            }
            next=curr;
        }

        return curr[target];
    }
}