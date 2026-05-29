class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        int[][] dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int bestStart = 0;
        int bestLength = 0;

        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                if (isPalindrome(s, start, end, dp)) {
                    int currentLength = end - start + 1;

                    if (currentLength > bestLength) {
                        bestStart = start;
                        bestLength = currentLength;
                    }
                }
            }
        }
        return s.substring(bestStart, bestStart + bestLength);
    }

    private boolean isPalindrome(String s, int left, int right, int[][] dp) {
        if (left >= right) {
            return true;
        }

        if (dp[left][right] != -1) {
            return dp[left][right] == 1;
        }

        if (s.charAt(left) != s.charAt(right)) {
            dp[left][right] = 0;
            return false;
        }

        boolean middleIsPalindrome = isPalindrome(s, left + 1, right - 1, dp);

        dp[left][right] = middleIsPalindrome ? 1 : 0;

        return middleIsPalindrome;
    }
}
