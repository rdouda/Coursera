import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int vertices = 0;
    private LinkedList<Integer>[] adjList;

    public Graph(int vertices){
        this.vertices = vertices;
        this.adjList = new LinkedList[vertices];
        for (int index = 0; index < vertices; index++)
            adjList[index] = new LinkedList<>();
    }

    // Method to add an edge between vertices u and v
    void addEdge(int u, int v){
        this.adjList[u].add(v);
    }

    // Method to perform Breadth-First Search (BFS)
    // traversal starting from a given node
    void BFS(int startNode){
        Queue<Integer> queue = new LinkedList<>();         // Queue to store nodes to visit
        boolean[] visited = new boolean[this.vertices];    // Array to mark visited nodes
        visited[startNode] = true;                         // Mark the starting node as visited
        queue.add(startNode);                              // Add the starting node to the queue
        while(!queue.isEmpty()){
            int currentNode = queue.poll();                // Dequeue a node from the queue
            System.out.println(currentNode);               // Process the dequeued node
                                                           // Visit all neighbors of the dequeued node
            for (int neighbor : this.adjList[currentNode]){
                if (!visited[neighbor]){                   // If neighbor is not visited
                    visited[neighbor] = true;              // Mark neighbor as visited
                    queue.add(neighbor);                   // Add neighbor to the queue for further exploration
                }
            }
        }
    }

    // Method to perform Breadth-First Search (BFS)
    // traversal from a starting node 's' to find the shortest path to an end node 'end'
    void BFS(int s, int end) {
                                                          // Initialize arrays to keep track of visited nodes and distances from the starting node
        boolean visited[] = new boolean[this.vertices];   // Array to mark visited nodes
        int dist[] = new int[this.vertices];              // Array to store distances from the starting node
        Queue<Integer> queue = new LinkedList<>();        // Queue to store nodes to visit
        visited[s] = true;                                // Mark the starting node as visited
        dist[s] = 0;                                      // Set distance from the starting node to itself as 0
        queue.add(s);                                     // Add the starting node to the queue
        // Perform BFS traversal
        while (!queue.isEmpty()) {
            int u = queue.poll();                         // Dequeue a node from the queue
            System.out.print(u + " ");                    // Print the dequeued node
            if(u == end)                                  // Check if the dequeued node is the end node
                break;                                    // Exit the loop if the end node is reached
                                                          // Visit all neighbors of the dequeued node
            for (int v : this.adjList[u]) {
                if (!visited[v]) {                        // If neighbor is not visited
                    visited[v] = true;                    // Mark neighbor as visited
                    dist[v] = dist[u] + 1;                // Update distance of neighbor from the starting node
                    queue.add(v);                         // Add neighbor to the queue for further exploration
                }
            }
        }
        System.out.println("\nShortest distance from " + s + " to " + end + " is: " + dist[end]);
    }
}
