class Solution {
    boolean flag;
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        List<Integer>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] e : edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        boolean[] visited = new boolean[n];
        dfs(graph,source,destination,visited);
        return flag;
    }

    private void dfs(List<Integer>[] graph,int s,int des,boolean[] visited){
        if(s == des){
            flag = true;
            return;
        }
        visited[s] = true;
        for(int neighbour : graph[s]){
            if(!visited[neighbour]){
                dfs(graph,neighbour,des,visited);
            }
        }
    }
}