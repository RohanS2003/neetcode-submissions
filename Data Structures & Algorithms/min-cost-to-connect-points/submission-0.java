class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        boolean[] visited = new boolean[n];
        int[] minCost = new int[n];

        Arrays.fill(minCost, Integer.MAX_VALUE);

        // Start from point 0
        minCost[0] = 0;

        int totalCost = 0;

        for (int count = 0; count < n; count++) {
            int currentPoint = -1;
            int currentMinCost = Integer.MAX_VALUE;

            // Find the unvisited point with minimum connection cost
            for (int i = 0; i < n; i++) {
                if (!visited[i] && minCost[i] < currentMinCost) {
                    currentMinCost = minCost[i];
                    currentPoint = i;
                }
            }

            // Add this point to MST
            visited[currentPoint] = true;
            totalCost += currentMinCost;

            // Update minCost for remaining unvisited points
            for (int nextPoint = 0; nextPoint < n; nextPoint++) {
                if (!visited[nextPoint]) {
                    int distance =
                        Math.abs(points[currentPoint][0] - points[nextPoint][0])
                      + Math.abs(points[currentPoint][1] - points[nextPoint][1]);

                    if (distance < minCost[nextPoint]) {
                        minCost[nextPoint] = distance;
                    }
                }
            }
        }
        //Time Complexity = O(n * (n + n)) = O(n^2)

        return totalCost;

    }
}
