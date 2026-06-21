class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dp=new int[m][n];
        // for(int[] r:dp){
        //     Arrays.fill(r,-1);
        // }

        for (int r = 0; r < m; r++) {
            dp[r][n - 1] = 1;
        }

        for (int c = 0; c < n; c++) {
            dp[m - 1][c] = 1;
        }

        for (int r = m - 2; r >= 0; r--) {
            for (int c = n - 2; c >= 0; c--) {
                dp[r][c] = dp[r][c + 1] + dp[r + 1][c];
            }
        }

        return dp[0][0];
        
        //return solve(0,0,m,n,dp);
    }

    private int solve(int r, int c, int m, int n, int [][] dp){
        if(r>=m || c>=n)
        return 0;

        if(r==m-1 && c==n-1)
        return 1;

        if(dp[r][c]!=-1)
        return dp[r][c];

        int right=solve(r,c+1,m,n,dp);
        int down=solve(r+1,c,m,n,dp);

        return dp[r][c]=right+down;
    }
}
