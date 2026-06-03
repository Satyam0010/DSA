class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int front = q.remove();
            for(int el : rooms.get(front)){
                if(!visited[el]){
                    q.add(el);
                    visited[el] = true;
                }
            }
        }

        for(boolean e : visited){
            if(!e) return false;
        }
        return true;
    }
}