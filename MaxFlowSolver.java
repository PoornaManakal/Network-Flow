import java.util.*;

public class MaxFlowSolver {
    private FlowNetwork network;
    private int[] parent;

    public MaxFlowSolver(FlowNetwork network) {
        this.network = network;
        this.parent = new int[network.getNumNodes()];
    }

    public int bfs(int source, int sink, Map<Integer, Edge> path) {
        Arrays.fill(parent, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        parent[source] = source;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (Edge edge : network.getEdges(current)) {
                if (parent[edge.to] == -1 && edge.residualCapacity() > 0) {
                    parent[edge.to] = current;
                    path.put(edge.to, edge);
                    if (edge.to == sink) {
                        return edge.residualCapacity();
                    }
                    queue.add(edge.to);
                }
            }
        }
        return 0;
    }

    public int fordFulkerson(int source, int sink) {
        int maxFlow = 0;
        Map<Integer, Edge> path = new HashMap<>();

        while (true) {
            path.clear();
            int flow = bfs(source, sink, path);
            if (flow == 0) {
                break;
            }

            // Find minimum residual capacity in the path
            int increment = Integer.MAX_VALUE;
            int node = sink;
            while (node != source) {
                Edge edge = path.get(node);
                increment = Math.min(increment, edge.residualCapacity());
                node = parent[edge.from];
            }

            // Update flows
            node = sink;
            while (node != source) {
                Edge edge = path.get(node);
                edge.flow += increment;

                // Find and update reverse edge
                for (Edge revEdge : network.getEdges(edge.to)) {
                    if (revEdge.to == edge.from) {
                        revEdge.flow -= increment;
                        break;
                    }
                }

                node = parent[edge.from];
            }

            maxFlow += increment;
        }

        return maxFlow;
    }

    // Final network output
    public void printFinalNetwork() {
        System.out.println("\n-- All original edges --");
        for (int u = 0; u < network.getNumNodes(); u++) {
            for (Edge e : network.getEdges(u)) {
                // Only show forward edges (original edges with positive capacity)
                if (e.capacity > 0) {
                    System.out.println("Edge " + e.from + " -> " + e.to +
                            " | flow = " + e.flow + " | cap = " + e.capacity);
                }
            }
        }
    }
}


