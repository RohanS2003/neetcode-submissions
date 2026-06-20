class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //we need <=k stops
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            graph.get(from).add(new int[] {to, price});
        }

        // dist[city][flightsUsed] = cheapest cost to reach city using flightsUsed flights
        int maxFlights = k + 1;
        int[][] dist = new int[n][maxFlights + 1];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        dist[src][0] = 0;

        minHeap.offer(new int[]{0,src,0});
        while(!minHeap.isEmpty()){
            int[] curr=minHeap.poll();
            int cost=curr[0];
            int city=curr[1];
            int flightsUsed=curr[2];

            if(city==dst){
                return cost;
            }

            if(cost>dist[city][flightsUsed]){
                continue;
            }

            if(flightsUsed==maxFlights)
            continue;

            for (int[] edge : graph.get(city)) {
                int nextCity = edge[0];
                int price = edge[1];

                int newCost = cost + price;
                int newFlightsUsed = flightsUsed + 1;

                if (newCost < dist[nextCity][newFlightsUsed]) {
                    dist[nextCity][newFlightsUsed] = newCost;
                    minHeap.offer(new int[] {newCost, nextCity, newFlightsUsed});
                }
            }
        }
        return -1;
    }
}
