class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();

        char[][] board=new char[n][n];

        for (int r = 0; r < n; r++) {
            Arrays.fill(board[r], '.');
        }

        Set<Integer> cols = new HashSet<>();
        Set<Integer> diagonals = new HashSet<>();      // row - col
        Set<Integer> antiDiagonals = new HashSet<>();  // row + col

        backtrack(0, n, board, cols, diagonals, antiDiagonals, ans);

        return ans;
    }

    private void backtrack(int row, int n, char[][] board,
                           Set<Integer> cols,
                           Set<Integer> diagonals,
                           Set<Integer> antiDiagonals,
                           List<List<String>> result) {
        if (row == n) {
            result.add(buildBoard(board));
            return;
        }

        for(int col=0;col<n;col++){
            if(cols.contains(col) || 
             diagonals.contains(row - col) ||
                antiDiagonals.contains(row + col)) {
                    continue;
                }
            
            board[row][col] = 'Q';
            cols.add(col);
            diagonals.add(row - col);
            antiDiagonals.add(row + col);

            backtrack(row + 1, n, board, cols, diagonals, antiDiagonals, result);

            board[row][col] = '.';
            cols.remove(col);
            diagonals.remove(row - col);
            antiDiagonals.remove(row + col);
        }
        
    }

    private List<String> buildBoard(char[][] board) {
        List<String> current = new ArrayList<>();

        for (int r = 0; r < board.length; r++) {
            current.add(new String(board[r]));
        }

        return current;
    }
}
