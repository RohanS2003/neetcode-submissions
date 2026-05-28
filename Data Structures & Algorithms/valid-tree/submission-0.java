class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1){
            return false;
        }
    

    List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = true;

        int visitedNodes=0;

        while(!q.isEmpty()){
            int node=q.poll();
            visitedNodes++;

            for(int neighbour:graph.get(node)){
                if(!visited[neighbour]){
                    visited[neighbour]=true;
                    q.offer(neighbour);
                }
            }
        }

        return visitedNodes==n;
    }
}
