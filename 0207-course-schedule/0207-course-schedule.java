class Solution {
    public boolean canFinish(int numCourses, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] p : pre) {
            adj.get(p[1]).add(p[0]);
            inDegree[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                q.offer(i);
        }
        int count = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;
            for (int next : adj.get(curr)) {
                inDegree[next]--;
                if (inDegree[next] == 0)
                    q.offer(next);
            }
        }
        return count == numCourses;
    }
}