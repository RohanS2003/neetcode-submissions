class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(board, word, r, c, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int index, boolean[][] visited){
        if(index==word.length()){
            return true;
        }

        if (r >= 0 && c >= 0 &&
            r < board.length && c < board[0].length &&
            !visited[r][c] &&
            board[r][c] == word.charAt(index)) {

            visited[r][c] = true;

            int[][] directions = {
                {1, 0},   // down
                {-1, 0},  // up
                {0, 1},   // right
                {0, -1}   // left
            };

            for (int[] dir : directions) {
                int newR = r + dir[0];
                int newC = c + dir[1];

                if (dfs(board, word, newR, newC, index + 1, visited)) {
                    visited[r][c] = false;
                    return true;
                }
            }
            
            visited[r][c] = false;
        }
        return false;
    }
}
