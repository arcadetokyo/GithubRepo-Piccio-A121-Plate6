import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class problem3 // DFS implementation
{
    private Stack<Integer> stack; // used to keep track of the vertices during DFS
    private int adjacencyMatrix[][]; // stores the graph's adjacency matrix

    public problem3()
    {
        stack = new Stack<Integer>(); // initializes the stack
    }

    public void dfs(int adjacency_matrix[][], int source) // dfs is an algo that walks through the graph - marking vertices it has visited
    {
        int number_of_nodes = adjacency_matrix[source].length - 1; // determines the number of nodes in the graph

        adjacencyMatrix = new int[number_of_nodes + 1][number_of_nodes + 1];
        for (int sourcevertex = 1; sourcevertex <= number_of_nodes; sourcevertex++)
        {
            for (int destinationvertex = 1; destinationvertex <= number_of_nodes; destinationvertex++)
            {
                adjacencyMatrix[sourcevertex][destinationvertex] =
                        adjacency_matrix[sourcevertex][destinationvertex];
            }
        }

        int visited[] = new int[number_of_nodes + 1]; // keeps track of visited nodes
        int element = source;
        int destination = source;
        visited[source] = 1;
        stack.push(source);

        while (!stack.isEmpty()) // continues until the stack is empty
        {
            element = stack.peek();
            destination = element;
            while (destination <= number_of_nodes)
            {
                if (adjacencyMatrix[element][destination] == 1 && visited[destination] == 1)
                {
                    if (stack.contains(destination))
                    {
                        System.out.println("The Graph contains cycle");
                        return;
                    }
                }

                if (adjacencyMatrix[element][destination] == 1 && visited[destination] == 0)
                {
                    stack.push(destination);
                    visited[destination] = 1;
                    adjacencyMatrix[element][destination] = 0;
                    element = destination;
                    destination = 1;
                    continue;
                }
                destination++;
            }
            stack.pop();

            // Cycle Detection: Checks for cycles by verifying if a destination vertex is already in the stack.
            // Visit Node: If an unvisited adjacent node is found, it is marked as visited and pushed onto the stack.
            // The adjacency matrix entry is reset to avoid revisiting the same edge.
            // Pop Stack: Removes the top element when no further adjacent unvisited nodes are found
        }
    }

    public static void main(String...arg)
    {
        int number_of_nodes, source;
        Scanner scanner = null;
        try
        {
            System.out.println("Enter the number of nodes in the graph");
            scanner = new Scanner(System.in);
            number_of_nodes = scanner.nextInt();

            int adjacency_matrix[][] = new int[number_of_nodes + 1][number_of_nodes + 1];
            System.out.println("Enter the adjacency matrix");
            for (int i = 1; i <= number_of_nodes; i++)
                for (int j = 1; j <= number_of_nodes; j++)
                    adjacency_matrix[i][j] = scanner.nextInt();

            System.out.println("Enter the source for the graph");
            source = scanner.nextInt();

            problem3 problem3 = new problem3();
            problem3.dfs(adjacency_matrix, source);

        } catch(InputMismatchException inputMismatch) // Catches and handles input mismatches
        {
            System.out.println("Wrong Input format");
        }
        scanner.close();
    }
}