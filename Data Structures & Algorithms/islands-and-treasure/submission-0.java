class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // Add all treasure chests to queue first
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        int[][] directions = {
            {1, 0},   // down
            {-1, 0},  // up
            {0, 1},   // right
            {0, -1}   // left
        };

        while(!queue.isEmpty()){
            int [] curr=queue.poll();
            int r=curr[0];
            int c=curr[1];

            for(int[] dir:directions){
                int newR = r + dir[0];
                int newC = c + dir[1];

                if (newR >= 0 && newC >= 0 &&
                    newR < rows && newC < cols &&
                    grid[newR][newC] == Integer.MAX_VALUE) {
                        grid[newR][newC]=grid[r][c]+1;
                        queue.offer(new int[]{newR, newC});
                    }
            }
        }
    }
}
