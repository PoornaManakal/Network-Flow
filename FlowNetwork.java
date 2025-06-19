import java.util.*;

public class FlowNetwork {
    private int numNodes;
    private List<Edge>[] adjList;

    @SuppressWarnings("unchecked")
    public FlowNetwork(int numNodes) {
        this.numNodes = numNodes;
        adjList = new ArrayList[numNodes];
        for (int i = 0; i < numNodes; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int from, int to, int capacity) {
        Edge edge = new Edge(from, to, capacity);
        Edge reverseEdge = new Edge(to, from, 0); // Reverse edge for residual graph
        adjList[from].add(edge);
        adjList[to].add(reverseEdge);
    }

    public List<Edge> getEdges(int node) {
        return adjList[node];
    }

    public int getNumNodes() {
        return numNodes;
    }
}
