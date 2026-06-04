class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int ans = 0;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i = 0 ; i < n;i++){
            for(int j = 0 ; j < n;j++){
                if(isConnected[i][j] == 1 && i != j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n ; i++){
            if(!visited[i]){
                dfs(i,adj,visited);
                ans++;
            }
        }
        return ans;
    }
    private void dfs(int node,List<List<Integer>> adj,boolean[] visited){
        visited[node] = true;
        for(int el : adj.get(node)){
            if(!visited[el]){
                dfs(el,adj,visited);
            }
        }
    }
}