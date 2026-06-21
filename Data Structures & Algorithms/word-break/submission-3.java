class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];

        dp[n] = true;

        // for (int i = n - 1; i >= 0; i--) {
        //     for (int end = i; end < n; end++) {
        //         String str = s.substring(i, end + 1);

        //         if (set.contains(str) && dp[end + 1]) {
        //             dp[i] = true;
        //             break;
        //         }
        //     }
        // }

        //space opti
        int maxLen = 0;
        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int len = 1; len <= maxLen && i + len <= n; len++) {
                String str = s.substring(i, i + len);

                if (set.contains(str) && dp[i + len]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
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
