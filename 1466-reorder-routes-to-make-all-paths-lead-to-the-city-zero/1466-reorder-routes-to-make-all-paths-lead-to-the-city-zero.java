class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] curr : connections){
            adj.get(curr[0]).add(new int[]{curr[1],1});
            adj.get(curr[1]).add(new int[]{curr[0],0});
        }
        boolean[] visited = new boolean[n];

        // DFS
        return dfs(0,adj,visited);

        // BFS

        // int ans = 0;
        // Queue<Integer> q = new LinkedList<>();
        // q.add(0);
        // while(!q.isEmpty()){
        //     int current = q.poll();
        //     visited[current] = true;
        //     for(int[] node : adj.get(current)){
        //         int next = node[0];
        //         int value = node[1];
        //         if( value == 0 && !visited[next]){
        //             q.add(next);
        //         } else if(value == 1 && !visited[next]){
        //             ans++;
        //             q.add(next);
        //         }
        //     }
        // }
        // return ans;
    }


    private int dfs(int current, List<List<int[]>> adj, boolean[] visited){
        visited[current] = true;
        int ans = 0;
        for(int[] node : adj.get(current)){
            int next = node[0];
            int value = node[1];

            if(!visited[next]){
                if(value == 1){
                    ans++;
                }
                ans += dfs(next,adj,visited);
            }
        }
        return ans;
    }
}