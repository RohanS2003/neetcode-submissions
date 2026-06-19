class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(nums,0,-1,dp);
    }

    private int solve(int[] nums, int i, int prevIdx, int[][] dp){
        if(i==nums.length){
            return 0;
        }

        //Arrays cannot use -1 as an index, so we shift it by +1

        if (dp[i][prevIdx+1] != -1) {
            return dp[i][prevIdx+1];
        }

        int take=0;
        if(prevIdx==-1 || nums[i]>nums[prevIdx]){
            take=1+solve(nums,i+1,i,dp);
        }
        int noTake=solve(nums,i+1,prevIdx,dp);
        
        return dp[i][prevIdx+1]=Math.max(take,noTake);
    }
}
