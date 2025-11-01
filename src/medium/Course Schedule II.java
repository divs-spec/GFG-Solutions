import java.util.*;

class Solution {
    public ArrayList<Integer> findOrder(int n, int[][] pre) {
        // adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        // build graph: edge from y -> x
        for (int[] p : pre) adj.get(p[1]).add(p[0]);

        boolean[] vis = new boolean[n];
        boolean[] pathVis = new boolean[n];
        Deque<Integer> st = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();

        // run DFS for all unvisited nodes
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                if (!dfs(i, adj, vis, pathVis, st)) {
                    // cycle detected → no valid order
                    return new ArrayList<>();
                }
            }
        }

        // stack has topological order in reverse
        while (!st.isEmpty()) res.add(st.pop());
        return res;
    }

    // DFS helper — returns false if cycle detected
    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj,
                        boolean[] vis, boolean[] pathVis, Deque<Integer> st) {
        vis[node] = true;
        pathVis[node] = true;

        for (int nei : adj.get(node)) {
            if (!vis[nei]) {
                if (!dfs(nei, adj, vis, pathVis, st)) return false;
            } else if (pathVis[nei]) {
                // back edge → cycle
                return false;
            }
        }

        pathVis[node] = false;
        st.push(node);
        return true;
    }
}
