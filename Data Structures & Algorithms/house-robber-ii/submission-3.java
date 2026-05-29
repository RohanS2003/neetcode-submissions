class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int excludeLast = robLinear(nums, 0, n - 2);
        int excludeFirst = robLinear(nums, 1, n - 1);

        return Math.max(excludeLast, excludeFirst);
    }

    private int robLinear(int[] nums, int start, int end) {
        int next1 = 0; // dp[i + 1]
        int next2 = 0; // dp[i + 2]

        for (int i = end; i >= start; i--) {
            int robCurrent = nums[i] + next2;
            int skipCurrent = next1;

            int curr = Math.max(robCurrent, skipCurrent);

            next2 = next1;
            next1 = curr;
        }

        return next1;
    }
}
