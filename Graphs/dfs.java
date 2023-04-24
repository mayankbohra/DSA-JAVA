import java.util.*;

public class dfs {
    public static void dfs_algo(ArrayList<ArrayList<Integer>> adj, int start) {
        int n = adj.size();
        boolean[] visited = new boolean[n]; // keep track of visited vertices
        Stack<Integer> st = new Stack<>(); // stack for DFS

        visited[start] = true; // mark starting vertex as visited
        st.push(start); // add starting vertex to the stack

        while (!st.empty()) {
            int u = st.pop(); // get the top vertex in the stack
            System.out.print(u + " ");

            // explore all adjacent vertices of u
            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    st.push(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(3);
        adj.get(3).add(3);

        System.out.println("DFS starting from vertex 2:");
        dfs_algo(adj, 2);
    }
}

// output
// DFS starting from vertex 2:
// 2 3 0 1 