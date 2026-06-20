class Solution {
    public int swimInWater(int[][] grid) {
        //https://www.youtube.com/watch?v=Gq81OeJNTwI
        int n = grid.length;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int[][] dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // {time, row, col}
        minHeap.offer(new int[] {grid[0][0], 0, 0});

        int[][] directions = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        dist[0][0]=grid[0][0];

        while(!minHeap.isEmpty()){
            int[] curr=minHeap.poll();

            int time=curr[0];
            int r=curr[1];
            int c=curr[2];

            if(time>dist[r][c]){
                continue;
            }

            if(r==n-1 && c==n-1)
            return time;

            for(int[] d:directions){
                int nextR=r+d[0];
                int nextC=c+d[1];

                if(nextR>=0 && nextR<n && nextC>=0 && nextC<n){
                    int newTime=Math.max(time, grid[nextR][nextC]);
                    if(newTime<dist[nextR][nextC]){
                        dist[nextR][nextC]=newTime;
                        minHeap.offer(new int[]{newTime,nextR,nextC});
                    }
                }
            }
        }
        return -1;
    }
}
