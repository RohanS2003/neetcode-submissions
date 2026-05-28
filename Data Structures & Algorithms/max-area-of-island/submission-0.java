class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        int maxArea = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    int area = dfs(grid, r, c, visited);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c, boolean[][] visited) {
        visited[r][c] = true;

        int area = 1;

        int[][] directions = {
            {1, 0},   // down
            {-1, 0},  // up
            {0, 1},   // right
            {0, -1}   // left
        };

        for (int[] dir : directions) {
            int newR = r + dir[0];
            int newC = c + dir[1];

            if (newR >= 0 && newC >= 0 &&
                newR < grid.length && newC < grid[0].length &&
                grid[newR][newC] == 1 &&
                !visited[newR][newC]) {

                area += dfs(grid, newR, newC, visited);
            }

        }
        return area;
    }
}
