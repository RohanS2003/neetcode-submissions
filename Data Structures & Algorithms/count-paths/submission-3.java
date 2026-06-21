class Solution {
    public int uniquePaths(int m, int n) {
        int[] next = new int[n];

        // Bottom row: every cell has exactly 1 path to destination
        Arrays.fill(next, 1);

        // Start from second-last row and move upward
        for (int r = m - 2; r >= 0; r--) {
            int[] curr = new int[n];

            // Last column: every cell has exactly 1 path to destination
            curr[n - 1] = 1;

            for (int c = n - 2; c >= 0; c--) {
                int right = curr[c + 1];
                int down = next[c];

                curr[c] = right + down;
            }

            // Current row becomes next row for the row above
            next = curr;
        }

        return next[0];
    }
}