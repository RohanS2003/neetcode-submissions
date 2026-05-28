class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        // Add all rotten fruits first and count fresh fruits
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }

        int minutes = 0;

        int[][] directions = {
            {1, 0},   // down
            {-1, 0},  // up
            {0, 1},   // right
            {0, -1}   // left
        };

        while(!queue.isEmpty() && fresh>0){
            int size=queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] dir : directions) {
                    int newR = r + dir[0];
                    int newC = c + dir[1];

                    if (newR >= 0 && newC >= 0 &&
                        newR < rows && newC < cols &&
                        grid[newR][newC] == 1){
                            grid[newR][newC]=2;
                            fresh--;
                            queue.offer(new int[] {newR, newC});
                        }
                }
            }
            minutes++;
        }

        return fresh==0?minutes:-1;
    }
}
