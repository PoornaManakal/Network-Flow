import java.io.*;

public class NetworkParser {

    public static FlowNetwork parseFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        int numNodes = Integer.parseInt(reader.readLine().trim());
        FlowNetwork network = new FlowNetwork(numNodes);

        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.trim().split("\\s+");
            int from = Integer.parseInt(parts[0]);
            int to = Integer.parseInt(parts[1]);
            int capacity = Integer.parseInt(parts[2]);
            network.addEdge(from, to, capacity);
        }
        reader.close();
        return network;
    }
}



