class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n;i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] edge : invocations){
            adj[edge[0]].add(edge[1]);
        }
        boolean[] suspicious = new boolean[n];
        dfs(k,adj,suspicious);
        for(int[] edge : invocations){
            int i = edge[0];
            int j = edge[1];
            if(!suspicious[i] && suspicious[j]){
            List<Integer> ans = new ArrayList<>();
                for(int ii = 0; ii < n; ii++){
                    ans.add(ii);
                }
                return ans;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n;i++){
            if(!suspicious[i]) ans.add(i);
        }
        return ans;
    }


    private void dfs(int node,List<Integer>[] adj,boolean[] suspicious){
        suspicious[node] = true;
        for(int next : adj[node]){
            if(!suspicious[next]){
                dfs(next,adj,suspicious);
            }
        }
    }
}