class Solution {
    public int climbStairs(int n) {
        // int [] dp=new int [n+1];
        // Arrays.fill(dp, -1);

        //return solve(n,dp);
        if(n==0 || n==1)
        return 1;

        int prev2=1;
        int prev1=1;

        for(int i=2;i<=n;i++){
            int curr=prev1+prev2;

            prev2=prev1;
            prev1=curr;
        }

        return prev1;
    }

    private int solve(int n, int [] dp){
        if(n==0 || n==1)
        return 1;

        if(dp[n]!=-1){
            return dp[n];
        }

        dp[n]=solve(n-1,dp)+solve(n-2,dp);
        return dp[n];
    }
}
