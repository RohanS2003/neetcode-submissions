class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        int[] parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for(int[] edge: edges){
            int a=edge[0];
            int b=edge[1];

            if(find(a,parent)==find(b,parent)){
                return edge;
            }

            union(a,b,parent);
        }
        return new int[0];
    }

    private int find(int node, int[] parent){
        if(parent[node]!=node){
            parent[node]=find(parent[node], parent);
        }
        return parent[node];
    }

    private void union(int a, int b, int [] parent){
        int parentA=find(a, parent);
        int parentB=find(b, parent);

        if(parentA!=parentB){
            parent[parentB]=parentA;
        }
    }
}
