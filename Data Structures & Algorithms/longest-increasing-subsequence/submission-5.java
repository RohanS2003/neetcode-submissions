class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        //int[][] dp = new int[n][n + 1];

        // for (int[] row : dp) {
        //     Arrays.fill(row, -1);
        // }

        //return solve(nums,0,-1,dp);

        //int[][] dp = new int[n+1][n + 1];
        //int[] curr=new int[n+1];
        int[] ahead=new int[n+1];
        for(int i=n-1;i>=0;i--){
            int[] curr = new int[n + 1];
            for(int prevIdx=i-1;prevIdx>=-1;prevIdx--){
                int noTake = ahead[prevIdx + 1];

                int take = 0;
                if (prevIdx == -1 || nums[i] > nums[prevIdx]) {
                    take = 1 + ahead[i + 1];
                }

                curr[prevIdx + 1] = Math.max(take, noTake);
            }
            ahead=curr;
        }
        return ahead[0];
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
