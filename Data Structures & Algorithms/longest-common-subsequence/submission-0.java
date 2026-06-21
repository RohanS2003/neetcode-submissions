class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0,0,text1,text2,dp);
    }

    private int solve(int i, int j, String text1, String text2, int[][] dp){
        if(i==text1.length() || j==text2.length())
        return 0;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if(text1.charAt(i)==text2.charAt(j)){
            dp[i][j]=1+solve(i+1,j+1,text1,text2,dp);
        }else{
            int skipText1 = solve(i + 1, j, text1, text2,dp);
            int skipText2 = solve(i, j + 1, text1, text2, dp);

            dp[i][j]=Math.max(skipText1, skipText2);
        }

        

        return dp[i][j];
    }
}
