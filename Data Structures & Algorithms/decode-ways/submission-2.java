class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        int next1 = 1; // dp[i + 1]
        int next2 = 0; // dp[i + 2]

        for (int i = n - 1; i >= 0; i--) {
            int curr=0;
            if (s.charAt(i) == '0') {
                curr = 0;
            } else {
                curr=next1;

                if (i + 1 < n) {
                    int value = Integer.parseInt(s.substring(i, i + 2));

                    if (value >= 10 && value <= 26) {
                        curr+=next2;
                    }
                }
            }
            next2=next1;
            next1=curr;
        }

        return next1;
    }

    private int solve(int i, String s, int[] dp) {
        if (i == s.length()) {
            return 1;
        }

        if (s.charAt(i) == '0') {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int oneDigit = solve(i + 1, s, dp);

        int twoDigit = 0;

        if (i + 1 < s.length()) {
            int value = Integer.parseInt(s.substring(i, i + 2));

            if (value >= 10 && value <= 26) {
                twoDigit = solve(i + 2, s, dp);
            }
        }

        dp[i] = oneDigit + twoDigit;

        return dp[i];
    }
}
