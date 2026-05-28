class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // 1. Add border O's from left and right columns
        for(int r=0;r<rows;r++){
            if (board[r][0] == 'O') {
                board[r][0] = '#';
                queue.offer(new int[]{r, 0});
            }

            if (board[r][cols - 1] == 'O') {
                board[r][cols - 1] = '#';
                queue.offer(new int[]{r, cols - 1});
            }
        }

         // 2. Add border O's from top and bottom rows
        for (int c = 0; c < cols; c++) {
            if (board[0][c] == 'O') {
                board[0][c] = '#';
                queue.offer(new int[]{0, c});
            }

            if (board[rows - 1][c] == 'O') {
                board[rows - 1][c] = '#';
                queue.offer(new int[]{rows - 1, c});
            }
        }

        int[][] directions = {
            {1, 0},   // down
            {-1, 0},  // up
            {0, 1},   // right
            {0, -1}   // left
        };

        // 3. BFS from border O's and mark connected O's as safe
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] dir : directions) {
                int newR = r + dir[0];
                int newC = c + dir[1];

                if (newR >= 0 && newC >= 0 &&
                    newR < rows && newC < cols &&
                    board[newR][newC] == 'O') {

                    board[newR][newC] = '#';
                    queue.offer(new int[]{newR, newC});
                }
            }
        }

        // 4. Flip surrounded O's and restore safe O's
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == '#') {
                    board[r][c] = 'O';
                }
            }
        }
    }
}
