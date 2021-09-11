import java.util.*;

public class GraphExample {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v); // edge is added from u to v
        adj.get(v).add(u); // edge is added from v to u
    }

    static void printGraph(ArrayList<ArrayList<Integer>> adj) {

        // printing for all vertices
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("\nAdjacency list of vertex" + i);
            System.out.print("head");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> " + adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {

        int V = 5; // number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V); // ArrayList of arrayList to store edges
                                                                                
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);

        printGraph(adj);

    }

}
