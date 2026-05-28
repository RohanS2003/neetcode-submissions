class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int islands = 0;

        boolean[][] visited = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    islands++;
                    dfs(grid, r, c, visited);
                }
            }
        }

        return islands;
    }

    private void dfs(char[][] grid, int r, int c, boolean[][] visited){
        visited[r][c]=true;

        int [][] directions={
            {1,0},
            {-1,0},
            {0,-1},
            {0,1}
        };

        for(int [] dir:directions){
            int newR=r+dir[0];
            int newC=c+dir[1];

            if (newR >= 0 && newC >= 0 &&
                newR < grid.length && newC < grid[0].length &&
                grid[newR][newC] == '1' &&
                !visited[newR][newC]) {

                dfs(grid, newR, newC, visited);
            }
        }
    }
}
