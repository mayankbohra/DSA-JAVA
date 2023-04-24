import java.util.*;

public class bfs {
    public static void bfs_algo(ArrayList<ArrayList<Integer>> adj, int start) {
        int n = adj.size();
        boolean[] visited = new boolean[n]; // keep track of visited vertices
        LinkedList<Integer> q = new LinkedList<>(); // queue for BFS

        visited[start] = true; // mark starting vertex as visited
        q.add(start); // add starting vertex to the queue

        while (!q.isEmpty()) {
            int u = q.poll(); // get the first vertex in the queue
            System.out.print(u + " ");

            // explore all adjacent vertices of u
            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {adj.add(new ArrayList<>());}

        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(3);
        adj.get(3).add(3);

        System.out.println("BFS starting from vertex 2:");
        bfs_algo(adj, 2);
    }
}

// output
// BFS starting from vertex 2:
// 2 0 3 1
