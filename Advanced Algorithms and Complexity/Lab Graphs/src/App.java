public class App {
    public static void main(String[] args) throws Exception {

        Graph graph = new Graph(8);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        graph.BFS(0);

        graph.BFS(2, 3);
    }
}
