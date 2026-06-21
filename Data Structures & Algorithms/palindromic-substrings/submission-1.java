class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int count=0;
        int[][] dp=new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(s,i,j,dp)){
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isPalindrome(String s, int left, int right, int[][] dp){
        if(left>=right)
        return true;

        if(dp[left][right]!=0)
        return dp[left][right]==1;

        if(s.charAt(left)!=s.charAt(right)){
            dp[left][right]=-1;
            return false;
        }

        boolean res=isPalindrome(s,left+1, right-1,dp);
        dp[left][right]=res?1:-1;

        return res;
    }
}
