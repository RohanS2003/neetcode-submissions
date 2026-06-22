class Solution {
    public boolean canJump(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];
        return solve(nums, 0, dp);
    }

    private boolean solve(int[] nums, int idx, Boolean[] dp){
        if(idx>=nums.length-1)
        return true;

        if (dp[idx] != null) {
            return dp[idx];
        }

        int maxJump=nums[idx];

        for(int jump=1;jump<=maxJump;jump++){
            if(solve(nums,idx+jump,dp)){
                dp[idx]=true;
                return true;
            }
        }

        dp[idx]=false;
        return false;
    }
}
