class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        //refer https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        if (Math.abs(target) > totalSum) {
            return 0;
        }

        if ((totalSum + target) < 0 || (totalSum + target) % 2 != 0) {
            return 0;
        }

        int subsetTarget = (totalSum + target) / 2;

        int[] next = new int[subsetTarget + 1];
        next[0] = 1;

        for (int index = nums.length - 1; index >= 0; index--) {
            int[] curr = new int[subsetTarget + 1];

            for (int currTarget = 0; currTarget <= subsetTarget; currTarget++) {
                int skip = next[currTarget];

                int take = 0;
                if (currTarget - nums[index] >= 0) {
                    take = next[currTarget - nums[index]];
                }

                curr[currTarget] = take + skip;
            }

            next = curr;
        }

        return next[subsetTarget];
    }
}
