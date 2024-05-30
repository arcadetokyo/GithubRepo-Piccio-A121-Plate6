import java.util.Scanner;

public class problem7 {
    private int[][] incidenceMatrix; // 2d array representing incidence matrix
    private int numVertices;
    private int numEdges;

    public problem7(int numVertices, int numEdges) {
        this.numVertices = numVertices;
        this.numEdges = numEdges;
        incidenceMatrix = new int[numVertices][numEdges];
        // initializes the instance variables and creates the incidence matrix with dimensions based on the number of vertices and edges.
    }

    public void addEdge(int edgeIndex, int vertex1, int vertex2, int count) {
        incidenceMatrix[vertex1][edgeIndex] = count;
        incidenceMatrix[vertex2][edgeIndex] = count;

        // Adds an edge between two vertices to the incidence matrix. It sets the count of connections between the edge and both vertices
    }

    public void printIncidenceMatrix() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numEdges; j++) {
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println();

            // Prints the incidence matrix to the console
            // Each row represents a vertex, and each column represents an edge, showing the count of connections.
        }
    }

    public static void problem7(String[] args) {

        // Input handling and graph creation logic
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int numVertices = scanner.nextInt();

        System.out.println("Enter the number of edges:");
        int numEdges = scanner.nextInt();

        problem7 graph = new problem7(numVertices, numEdges);

        System.out.println("Enter the edges in the format 'vertex1 vertex2 count':");
        for (int i = 0; i < numEdges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            int count = scanner.nextInt();
            graph.addEdge(i, vertex1, vertex2, count);
        }

        System.out.println("The incidence matrix of the graph is:");
        graph.printIncidenceMatrix();

        scanner.close();
    }
}