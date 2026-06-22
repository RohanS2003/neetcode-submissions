class Solution {
    public boolean canJump(int[] nums) {
        return solve(nums,0);
    }

    private boolean solve(int[] nums, int idx){
        if(idx>=nums.length-1)
        return true;

        int maxJump=nums[idx];

        for(int jump=1;jump<=maxJump;jump++){
            if(solve(nums,idx+jump))
            return true;
        }

        return false;
    }
}
