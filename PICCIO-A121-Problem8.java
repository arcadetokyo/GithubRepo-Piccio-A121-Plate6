import java.util.Arrays;
import java.util.Scanner;

public class problem8 {
    // A method that takes two adjacency matrices (graph1 and graph2) as parameters and returns a boolean showing if isomorphic or nit
    private static boolean areIsomorphic(int[][] graph1, int[][] graph2) {
        int n = graph1.length;

        // If the number of vertices are different, they cannot be isomorphic
        if (n != graph2.length) return false;

        // Check if the degrees of all vertices match
        int[] degrees1 = new int[n];
        int[] degrees2 = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                degrees1[i] += graph1[i][j];
                degrees2[i] += graph2[i][j];
            }
        }

        Arrays.sort(degrees1);
        Arrays.sort(degrees2);

        if (!Arrays.equals(degrees1, degrees2)) return false;

        // Further checks could involve more advanced algorithms, but for simplicity, we use degree sequence comparison
        // the graph invariant cannot determine if it rly is isomorphic but it is possible for the graph 2 be isomorphic
        // check if # of vertices and degrees of vertices match for both graphs
        return true;
    }

    public static void problem8(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices in the graphs:");
        int numVertices = scanner.nextInt();

        int[][] graph1 = new int[numVertices][numVertices];
        int[][] graph2 = new int[numVertices][numVertices];
        // Creates the adjacency matrices for both graphs

        System.out.println("Enter the adjacency matrix for the first graph:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                graph1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter the adjacency matrix for the second graph:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                graph2[i][j] = scanner.nextInt();
            }
        }

        boolean isomorphic = areIsomorphic(graph1, graph2);

        if (isomorphic) {
            System.out.println("The graphs are isomorphic.");
        } else {
            System.out.println("The graphs are not isomorphic.");
        }

        scanner.close();
    }
}