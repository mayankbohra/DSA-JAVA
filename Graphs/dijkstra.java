import java.util.*;

public class dijkstra {

    public static int[] dijkstra_algo(ArrayList<ArrayList<int[]>> adj, int src) {
        int n = adj.size();

        int[] dist = new int[n];    // to store the shortest path distances from the source vertex
        boolean[] visited = new boolean[n]; //to keep track of visited vertices
        Arrays.fill(dist, Integer.MAX_VALUE);

        // priority queue to store the vertices and their corresponding distances
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{src, 0});
        dist[src] = 0;

        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int u = edge[0];

            // If the vertex has already been visited, skip it
            if (visited[u]){continue;}

            visited[u] = true;

            // Loop through all the adjacent vertices of the current vertex
            for (int[] v : adj.get(u)) {
                int vertex = v[0];
                int weight = v[1];

                // If the adjacent vertex has not been visited and its distance is
                // greater than the distance of the current vertex plus the weight of the edge between them
                if (!visited[vertex] && dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[vertex]) {
                    dist[vertex] = dist[u] + weight;
                    pq.add(new int[]{vertex, dist[vertex]});
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int n = 5;
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
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

        int[] dist = dijkstra_algo(adj, 0);
        System.out.println("Shortest path is -> " + Arrays.toString(dist)); 
    }
}

// output
// Shortest path is -> [0, 2, 5, 6, 7]