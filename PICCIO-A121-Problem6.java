import java.util.ArrayList;
import java.util.Scanner;

public class problem6 {
    private int[][] adjacencyMatrix; // 2D array to store the adjacency matrix
    private int numVertices; // Stores the number of vertices in the graph

    public problem6(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int fromVertex, int toVertex) {
        adjacencyMatrix[fromVertex][toVertex]++;

        // Increments the count of edges between two vertices in the adjacency matrix
        // This method is used to add edges to the graph
    }

    public void printAdjacencyMatrix() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();

            // prints the adjacency matrix to the console
            // it iterates through the matrix and prints each element
        }
    }

    public static void problem6(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int numVertices = scanner.nextInt();

        problem6 problem6 = new problem6(numVertices);

        System.out.println("Enter the number of edges:");
        int numEdges = scanner.nextInt();

        System.out.println("Enter the edges in the format 'fromVertex toVertex':");
        for (int i = 0; i < numEdges; i++) {
            int fromVertex = scanner.nextInt();
            int toVertex = scanner.nextInt();
            problem6.addEdge(fromVertex, toVertex);
        }

        System.out.println("The adjacency matrix of the problem6 is:");
        problem6.printAdjacencyMatrix();


        // Asks the user for the number of edges and then for each edge
        // asks for the fromVertex and toVertex, adding them to the adjacency matrix using the addEdge method.

        scanner.close();
    }
}