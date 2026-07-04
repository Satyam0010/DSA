class Solution {

    boolean[] visited;
    List<List<int[]>> adj = new ArrayList<>();
    int cost = Integer.MAX_VALUE;
    
    
    public int minScore(int n, int[][] roads) {
        visited = new boolean[n+1];
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] road : roads){
            int x = road[0];
            int y = road[1];
            int z = road[2];
            adj.get(x).add(new int[]{y, z});
            adj.get(y).add(new int[]{x, z});
        }
        dfs(1);
        return cost;
    }

    private void dfs(int node){
        visited[node] = true;
        for(int[] e : adj.get(node)){
            int neighbour = e[0];
            int weight = e[1];
            cost = Math.min(cost,weight);
        if(!visited[neighbour]){
            dfs(neighbour);
        }
        }
    }
}