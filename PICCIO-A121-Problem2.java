import java.util.HashMap; //  implements the Map interface and is used to store key-value pairs
import java.util.Map; // represents a collection of key-value pairs
import java.util.Scanner;




public class problem2 {
    public static void problem2(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int vertices = scanner.nextInt();
        // ask vertices bc adjacency matrix dimension depends on number of vertices

        int[][] adjMatrix = new int[vertices][vertices];
        System.out.println("Enter the adjacency matrix:"); // loop to input values for every row based on number of vertices
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                adjMatrix[i][j] = scanner.nextInt();
            }
        }

        // Initialize 2D array to store the adjacency matrix based on the number of vertices
        // Matrix Input - Reads the adjacency matrix from the user. Each entry represents the presence and weight of an edge between two vertices

        Map<String, Integer> edgeCount = new HashMap<>();

        for (int i = 0; i < vertices; i++) { // iterate over the adjacency matrix
            for (int j = 0; j < vertices; j++) {
                if (adjMatrix[i][j] != 0) { // check if adjacent
                    String edge = i < j ? i + " -> " + j : j + " -> " + i;
                    edgeCount.put(edge, edgeCount.getOrDefault(edge, 0) + adjMatrix[i][j]); // edgecount = hashmap bc for unique edges, checks count, no duplicates bc undirected graph
                }
            }

            // Edge Check: Checks if there is an edge between vertices (i, j). If adjMatrix[i][j] is not zero, it means there is an edge
            // Edge Representation: Creates a string representation of the edge. The condition i < j ? i + " -> " + j : j + " -> " + i ensures that each edge is represented in a unique way for an undirected graph
            // Edge Count Update: Updates the count of the edge in the HashMap. The method getOrDefault(edge, 0) retrieves the current count or returns 0 if the edge is not yet in the map

        }

        System.out.println("Edges and their counts:");
        for (Map.Entry<String, Integer> entry : edgeCount.entrySet()) {
            System.out.println("Edge " + entry.getKey() + " appears " + entry.getValue() + " times");
        }

        scanner.close();
    }
}