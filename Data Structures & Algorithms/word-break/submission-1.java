class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>(wordDict);
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return solve(s,0,set,dp);
    }

    private boolean solve(String s, int i, Set<String> set, int[] dp){
        int n=s.length();
        if(i==n)
        return true;

        if (dp[i] != -1) {
            return dp[i] == 1;
        }

        for(int end=i;end<n;end++){
            String str=s.substring(i,end+1);
            if(set.contains(str)){
                if(solve(s,end+1,set,dp)){
                    dp[i]=1;
                    return true;
                }
            }
        }
        dp[i]=0;
        return false;
    }
}
