import java.util.ArrayList;
import java.util.Scanner;

public class problem1 {
    private ArrayList<ArrayList<Integer>> adjacencyList;
    private boolean[] visited;
    private int numVertices; // A boolean array to keep track of which vertices have been visited during traversal

    public problem1(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        visited = new boolean[numVertices]; // Initializes the graph with a given number of vertices, setting up the adjacency list and the visited array.
    }

    public void addEdge(int vertex1, int vertex2) {
        adjacencyList.get(vertex1).add(vertex2);
        adjacencyList.get(vertex2).add(vertex1);
        // Adds an undirected edge between two vertices by adding each vertex to the other's adjacency list
    }

    private void dfs(int vertex) { // traverse the graph
        // It marks the current vertex as visited and recursively visits all unvisited neighbors
        visited[vertex] = true;
        for (int neighbor : adjacencyList.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    public boolean isConnected() { // traverse the graph and check if all vertices were visited
        dfs(0);
        for (boolean vertexVisited : visited) {
            if (!vertexVisited) {
                return false;
            }
        }
        return true;
    }

    public int countConnectedComponents() { // check if a vertex was not visited and traverse it if didnt
        int count = 0;
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }
        return count;
    }

    public static void problem1(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int numVertices = scanner.nextInt();

        System.out.println("Enter the number of edges:");
        int numEdges = scanner.nextInt();

        problem1 graph = new problem1(numVertices);

        System.out.println("Enter the edges in the format of the first vertex followed by the second vertex");
        for (int i = 0; i < numEdges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            graph.addEdge(vertex1, vertex2);
        }

        if (graph.isConnected()) {
            System.out.println("The graph is connected.");
        } else {
            int numComponents = graph.countConnectedComponents();
            System.out.println("The graph is not connected.");
            System.out.println("Number of connected components: " + numComponents);
        }

        scanner.close();
    }
}