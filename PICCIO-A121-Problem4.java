import java.util.HashMap; // store the degree of each vertex
import java.util.Map; // provides a mapping between keys (vertices) and values (degrees)
import java.util.Scanner;

public class problem4 {
    public static void problem4(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int vertices = scanner.nextInt();

        System.out.println("Enter the number of edges:");
        int edges = scanner.nextInt();

        Map<Integer, Integer> degreeCount = new HashMap<>();

        System.out.println("Enter the edges (pairs of vertices):"); // uses hashmap bc vertices r unique
        for (int i = 0; i < edges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();

            // for each edge, increments the degree count of both vertices in the edge.
            // uses getOrDefault to handle vertices that are not yet in the map by providing a default degree of 0
            degreeCount.put(vertex1, degreeCount.getOrDefault(vertex1, 0) + 1); //
            degreeCount.put(vertex2, degreeCount.getOrDefault(vertex2, 0) + 1);
        }

        System.out.println("Degree of each vertex:");
        for (int i = 0; i < vertices; i++) {
            int degree = degreeCount.getOrDefault(i, 0);
            System.out.println("Vertex " + i + " has degree " + degree);
        } //  iterates over all vertices and prints the degree of each vertex
        // uses getOrDefault to handle vertices that have no edges by providing a default degree of 0

        scanner.close();
    }
}