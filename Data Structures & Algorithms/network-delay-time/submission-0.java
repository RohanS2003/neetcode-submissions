class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] time: times){
            int u=time[0];
            int v=time[1];
            int w=time[2];

            adj.get(u).add(new int[]{v,w});
        }

        PriorityQueue<int[]> pq=new PriorityQueue<>(
            (a,b)->Integer.compare(a[1], b[1])
        );

        int[] dist=new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.offer(new int[]{k,0});
        dist[k]=0;

        while(!pq.isEmpty()){
            int[] curr=pq.poll();

            int currNode=curr[0];
            int currTime=curr[1];

            if(currTime>dist[currNode])
            continue;

            for(int[] neighbour:adj.get(currNode)){
                int neighbourNode=neighbour[0];
                int neighbourTravelTime=neighbour[1];

                if(dist[currNode]+neighbourTravelTime<dist[neighbourNode]){
                    dist[neighbourNode]=dist[currNode]+neighbourTravelTime;
                    pq.offer(new int[]{neighbourNode,dist[neighbourNode]});
                }
            }
        }
        int answer = 0;

        for (int node = 1; node <= n; node++) {
            if (dist[node] == Integer.MAX_VALUE) {
                return -1;
            }

            answer = Math.max(answer, dist[node]);
        }

        return answer;
    }
}
