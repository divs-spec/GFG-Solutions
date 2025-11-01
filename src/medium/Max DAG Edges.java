class Solution {
    public int maxEdgesToAdd(int V, int[][] edges) {
        // Code here
        int E = edges.length;
        int maxPossible = ((V * (V - 1)) / 2);
        return maxPossible - E;
    }
}



import java.util.*;

public class MaxEdgesToAdd {

    static class Solution {
        public int maxEdgesToAdd(int V, int[][] edges) {
            // Build adjacency matrix
            int[][] adj = new int[V + 1][V + 1];

            // Fill adjacency matrix for existing edges
            for (int[] e : edges) {
                int u = e[0];
                int v = e[1];
                adj[u][v] = 1;
                adj[v][u] = 1; // undirected
            }

            int missing = 0;

            // Check all possible pairs (i, j)
            for (int i = 1; i <= V; i++) {
                for (int j = i + 1; j <= V; j++) {
                    if (adj[i][j] == 0) {
                        missing++;
                    }
                }
            }

            return missing;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices (V): ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges (E): ");
        int E = sc.nextInt();

        int[][] edges = new int[E][2];
        System.out.println("Enter edges (u v):");
        for (int i = 0; i < E; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        Solution sol = new Solution();
        int result = sol.maxEdgesToAdd(V, edges);

        System.out.println("Maximum edges that can be added: " + result);

        sc.close();
    }
}
