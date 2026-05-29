class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(0, s, dp);
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
