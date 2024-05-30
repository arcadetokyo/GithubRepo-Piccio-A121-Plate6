import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class problem5 {
    public static void problem5(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int vertices = scanner.nextInt();

        System.out.println("Enter the number of edges:");
        int edges = scanner.nextInt();

        List<List<Integer>> adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());

            // Adjacency List: Initializes a list of lists to store the adjacency list representation of the graph
            // Initialization Loop: Adds an empty list for each vertex to the adjacency list
        }

        System.out.println("Enter the edges (pairs of vertices):");
        for (int i = 0; i < edges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
        }
        // adds each edge to the adjacency list
        // ensuring the graph is undirected by adding the edge in both directions.

        if (isBipartite(adjList, vertices)) {
            System.out.println("The graph is bipartite");
        } else {
            System.out.println("The graph is not bipartite");
        }

        // calls the isBipartite method to check if the graph is bipartite

        scanner.close();
    }

    // determines if the graph is bipartite
    private static boolean isBipartite(List<List<Integer>> adjList, int vertices) {
        int[] colors = new int[vertices]; // 0: uncolored, 1: color1, -1: color2
        for (int i = 0; i < vertices; i++) {
            colors[i] = 0;
        } //  used to store the color of each vertex (0 for uncolored, 1 for one color, -1 for the other color)

        for (int i = 0; i < vertices; i++) {
            if (colors[i] == 0) {
                if (!bfsCheck(adjList, i, colors)) {
                    return false;
                }
            }
        }
        return true;

        // iterates through each vertex and performs a BFS check if the vertex is uncolored.
    }


    // performs a BFS to check if the component starting from the given vertex is bipartite
    private static boolean bfsCheck(List<List<Integer>> adjList, int start, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        colors[start] = 1; // Start coloring with color 1

        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            for (int neighbor : adjList.get(vertex)) {
                if (colors[neighbor] == 0) {
                    colors[neighbor] = -colors[vertex]; // Color with opposite color
                    queue.add(neighbor);
                } else if (colors[neighbor] == colors[vertex]) {
                    return false; // Found a same color neighbor

                    // Color Initialization: Colors the starting vertex with color 1
                    // BFS Loop: Continues until the queue is empty
                    // Neighbor Check: For each neighbor of the current vertex
                    // If the neighbor is uncolored, it is colored with the opposite color and added to the queue
                    // If the neighbor has the same color as the current vertex, the graph is not bipartite, and the method returns false
                }
            }
        }
        return true;
    }
}