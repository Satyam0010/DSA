class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for(int i = 0; i < n ; i++){
            color[i] = -1;
        }
        for(int i = 0; i < n; i++){
            if(color[i] != -1) continue;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            color[i] = 0;
            while(!q.isEmpty()){
                Integer node = q.remove();
                for(int el : graph[node]){
                    if(color[el] == -1){
                        color[el] = 1 - color[node];
                        q.add(el);
                    } else if(color[el] == color[node]) return false;
                }
            }
        }
        return true;
    }
}