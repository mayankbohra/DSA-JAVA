import java.util.*;

public class prims {
    public static int prim(ArrayList<ArrayList<int[]>> adj, int start) {
        int n = adj.size();
        
        int[] key = new int[n]; // used to pick minimum weight
        int[] parent = new int[n];  // used to store the visited vertex
        boolean[] visited = new boolean[n]; // keep track of visited vertices
        Arrays.fill(key,Integer.MAX_VALUE);

        // Priority queue to store edges with minimum weight
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        pq.add(new int[] {start,0,});
        key[start] = 0; // mark starting vertex as visited
        int sum = 0;

        while (!pq.isEmpty()) {
            int[] u = pq.poll(); // get the edge with the minimum weight
            int vertex = u[0];
            int weight = u[1];

            // Skip if the vertex has already been visited
            if(visited[vertex]){continue;}

            visited[vertex] = true;
            sum += weight;

            // Iterate through all the edges adjacent to the vertex
            for(int[] edge : adj.get(vertex)){
                int v = edge[0];
                int w = edge[1];

                // Update the key array and add the edge to the priority queue
                // if the vertex is not visited and the weight is less than the current key
                if(!visited[v] && w<key[v]){
                    key[v] = w;
                    parent[v] = vertex;
                    pq.add(new int[] {v, w});
                }
            }
        }
        for (int i = 1; i < n; i++) {System.out.println(parent[i] + " - " + i);}

        return sum;
    }

    public static void main(String[] args) {
        int n = 5;

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {adj.add(new ArrayList<>());}

        // add edges to the graph
        adj.get(0).add(new int[]{1, 2});
        adj.get(0).add(new int[]{3, 6});
        adj.get(1).add(new int[]{0, 2});
        adj.get(1).add(new int[]{2, 3});
        adj.get(1).add(new int[]{3, 8});
        adj.get(1).add(new int[]{4, 5});
        adj.get(2).add(new int[]{1, 3});
        adj.get(2).add(new int[]{4, 7});
        adj.get(3).add(new int[]{0, 6});
        adj.get(3).add(new int[]{1, 8});
        adj.get(3).add(new int[]{4, 9});
        adj.get(4).add(new int[]{1, 5});
        adj.get(4).add(new int[]{2, 7});
        adj.get(4).add(new int[]{3, 9});

        System.out.println("Minimum Spanning Tree using Prim's algorithm:");
        System.out.println("Minimum weight  is -> " + prim(adj, 0));
    }
}

// Minimum Spanning Tree using Prim's algorithm:
// 0 - 1
// 1 - 2
// 0 - 3
// 1 - 4
// Minimum weight  is -> 16