import java.util.*;

public class kruskal {
    public static int[] parent;
    public static int find(int x) {
        if (parent[x] == x) {return x;}

        // recursively find the root of the set that contains x
        parent[x] = find(parent[x]);
        return parent[x];
    }

    // Merge two disjoint sets
    public static void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        // If x and y belong to different sets, merge the sets
        if (px != py) {parent[px] = py; }
    }

    public static void algo(int[][] edges, int n){
        ArrayList<int[]> edgeList = new ArrayList<>();

        // Convert the array of edges to an ArrayList of edges
        for (int[] edge : edges) {edgeList.add(edge);}

        // Sort the edges in ascending order of their weights
        edgeList.sort(Comparator.comparingInt(edge -> edge[2]));
        int sum = 0;

        // Initialize parent array for the disjoint set
        parent = new int[n];

        // Initially, each node is the root of its own set
        for (int i = 0; i < n; i++) {parent[i] = i; }

        List<int[]> mst = new ArrayList<>(); // list to store edges of MST
        for (int[] edge : edgeList) {
            int u = edge[0];
            int v = edge[1];
//            sum += edge[2];

            // check for cycle, if no cycle add it to MST
            if (find(u) != find(v)) {
                union(u, v); // Merge the sets containing u and v
                mst.add(edge); // Add the edge to MST
            }
        }
        // Print MST
        for (int[] edge : mst) {
            System.out.printf("(%d, %d) -> %d\n", edge[0], edge[1], edge[2]);
            sum += edge[2];
        }
        System.out.println("Minimum weight is -> " + sum);
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
                {0, 1, 2},
                {0, 3, 6},
                {1, 2, 3},
                {1, 3, 8},
                {1, 4, 5},
                {2, 4, 7},
                {3, 4, 9}
        };
        algo(edges, n);
    }
}

// output
// (0, 1) -> 2
// (1, 2) -> 3
// (1, 4) -> 5
// (0, 3) -> 6
// Minimum weight is -> 16