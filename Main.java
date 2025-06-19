import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\nEnter the name of the file to run (eg : bridge_1.txt / ladder_1.txt ), or type 'exit' to quit: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println(" Program exited !!! ");
                break;
            }

            File file = new File("benchmarks/" + input);
            if (!file.exists()) {
                System.out.println(" File not found. Please try again with a valid name.");
                continue;
            }

            try {
                FlowNetwork network = NetworkParser.parseFile(file.getPath());
                MaxFlowSolver solver = new MaxFlowSolver(network);

                int source = 0;
                int sink = network.getNumNodes() - 1;

                long startTime = System.nanoTime();
                int maxFlow = solver.fordFulkerson(source, sink);
                long endTime = System.nanoTime();

                double elapsedTimeMillis = (endTime - startTime) / 1_000_000.0;

                solver.printFinalNetwork();

                System.out.println("\n-------------------------------------");
                System.out.println(" File: " + file.getName());
                System.out.println(" Maximum Flow: " + maxFlow);
                System.out.printf(" Time Taken: %.2f ms\n", elapsedTimeMillis);
                System.out.println("-------------------------------------");

            } catch (Exception e) {
                System.out.println(" Error processing the file.");
                e.printStackTrace();
            }
        }

        scanner.close();
    }
}






