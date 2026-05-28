class Solution {
    public int countComponents(int n, int[][] edges) {
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

        int components=0;

        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                components++;
                dfs(node, graph, visited);
            }
        }

        return components;
    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] visited){
        visited[node]=true;

        for(int neighbour:graph.get(node)){
            if(!visited[neighbour]){
                dfs(neighbour, graph, visited);
            }
        }
    }
}
