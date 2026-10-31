class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        Map<String,Map<String,Double>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            Double value = values[i];
            adj.putIfAbsent(u,new HashMap<>());
            adj.putIfAbsent(v,new HashMap<>());
            adj.get(u).put(v,value);
            adj.get(v).put(u,1.0/value);
        }
        double[] ans = new double[queries.size()];
        for(int i = 0; i < queries.size();i++){
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);
            if(!adj.containsKey(src) || !adj.containsKey(dest)){
                ans[i] = -1.0;
            } else if((src).equals(dest)) {
                ans[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                ans[i] = dfs(adj,src,dest,visited);
            }
        }
        return ans;
    }


    private double dfs(Map<String,Map<String,Double>> adj, String curr,String dest,Set<String> visited){
        if(curr.equals(dest)) return 1.0;

        visited.add(curr);
        Map<String,Double> neighbours = adj.get(curr);
        for(Map.Entry<String,Double> neighbour : neighbours.entrySet()){
            String next = neighbour.getKey();
            Double weight = neighbour.getValue();
            if(!visited.contains(next)){
                Double nextPro = dfs(adj,next,dest,visited);
                if(nextPro != -1) return nextPro*weight;
            }
        }
        return -1.0;
    }
}