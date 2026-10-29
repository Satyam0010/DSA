import java.util.*;

class Solution {
    private int[] parent, depth, heavy, head, pos;
    private int curPos;
    private List<Integer>[] adj;
    private int[] tree; 
    private int[] initialMasks;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        parent = new int[n];
        depth = new int[n];
        heavy = new int[n];
        head = new int[n];
        pos = new int[n];
        Arrays.fill(heavy, -1);

        dfsSize(0, -1, 0);

        curPos = 0;
        dfsDecompose(0, 0);

        initialMasks = new int[n];
        for (int i = 0; i < n; i++) {
            initialMasks[pos[i]] = 1 << (s.charAt(i) - 'a');
        }

        tree = new int[4 * n];
        buildTree(1, 0, n - 1);

        List<Boolean> ansList = new ArrayList<>();
        char[] currentChars = s.toCharArray();

        for (String q : queries) {
            String[] tokens = q.split(" ");
            if (tokens[0].equals("update")) {
                int u = Integer.parseInt(tokens[1]);
                char c = tokens[2].charAt(0);
                
                int oldBit = 1 << (currentChars[u] - 'a');
                int newBit = 1 << (c - 'a');
                currentChars[u] = c;

                updateTree(1, 0, n - 1, pos[u], oldBit ^ newBit);
            } else {
                int u = Integer.parseInt(tokens[1]);
                int v = Integer.parseInt(tokens[2]);
                
                int pathMask = queryPath(u, v, n);
                
                boolean isPalindrome = (pathMask & (pathMask - 1)) == 0;
                ansList.add(isPalindrome);
            }
        }

        return ansList;
    }

    private int dfsSize(int u, int p, int d) {
        parent[u] = p;
        depth[u] = d;
        int size = 1;
        int maxSubtreeSize = 0;
        for (int v : adj[u]) {
            if (v != p) {
                int vSize = dfsSize(v, u, d + 1);
                size += vSize;
                if (vSize > maxSubtreeSize) {
                    maxSubtreeSize = vSize;
                    heavy[u] = v;
                }
            }
        }
        return size;
    }

    private void dfsDecompose(int u, int h) {
        head[u] = h;
        pos[u] = curPos++;
        if (heavy[u] != -1) {
            dfsDecompose(heavy[u], h);
        }
        for (int v : adj[u]) {
            if (v != parent[u] && v != heavy[u]) {
                dfsDecompose(v, v);
            }
        }
    }

    private void buildTree(int node, int start, int end) {
        if (start == end) {
            tree[node] = initialMasks[start];
            return;
        }
        int mid = (start + end) / 2;
        buildTree(2 * node, start, mid);
        buildTree(2 * node + 1, mid + 1, end);
        tree[node] = tree[2 * node] ^ tree[2 * node + 1];
    }

    private void updateTree(int node, int start, int end, int idx, int xorVal) {
        if (start == end) {
            tree[node] ^= xorVal;
            return;
        }
        int mid = (start + end) / 2;
        if (idx <= mid) {
            updateTree(2 * node, start, mid, idx, xorVal);
        } else {
            updateTree(2 * node + 1, mid + 1, end, idx, xorVal);
        }
        tree[node] = tree[2 * node] ^ tree[2 * node + 1];
    }

    private int queryTree(int node, int start, int end, int l, int r) {
        if (r < start || end < l) return 0;
        if (l <= start && end <= r) return tree[node];
        int mid = (start + end) / 2;
        return queryTree(2 * node, start, mid, l, r) ^ queryTree(2 * node + 1, mid + 1, end, l, r);
    }

    private int queryPath(int u, int v, int n) {
        int res = 0;
        while (head[u] != head[v]) {
            if (depth[head[u]] > depth[head[v]]) {
                int temp = u; u = v; v = temp;
            }
            res ^= queryTree(1, 0, n - 1, pos[head[v]], pos[v]);
            v = parent[head[v]];
        }
        if (depth[u] > depth[v]) {
            int temp = u; u = v; v = temp;
        }
        res ^= queryTree(1, 0, n - 1, pos[u], pos[v]);
        return res;
    }
}
