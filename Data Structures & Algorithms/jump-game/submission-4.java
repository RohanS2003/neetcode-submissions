class Solution {
    public boolean canJump(int[] nums) {
        // farthest index we can reach so far
        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {
            // if current index is not reachable, we are stuck
            if (i > farthest) {
                return false;
            }

            // from index i, we can reach up to i + nums[i]
            farthest = Math.max(farthest, i + nums[i]);

            // if we can reach or cross the last index, answer is true
            if (farthest >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}
