# Maximum Flow Algorithm (Edmonds-Karp) – Java

## 📖 Introduction
This is a Java-based implementation of the **Maximum Flow Problem** using the **Ford-Fulkerson algorithm with BFS (Edmonds-Karp variant)**.  
The program calculates the maximum flow from a **source node** to a **sink node** in a directed flow network with capacities on edges.

---

## ⚙️ Setup Instructions

### Requirements
- Java 17 or higher
- Any Java IDE (NetBeans, IntelliJ, Eclipse, etc.)
- Command Line or Terminal for execution
- Text files for input (benchmark graphs)

---

### Running the Project
1. Open the project in your Java IDE.  
2. Place input files in the **`benchmarks/`** folder.  
3. Compile all Java files:

    ```bash
    javac *.java
    ```
5. Run the program:

    ```bash
    java Main
    ```
7. Follow the prompt:  
   Enter input file name (e.g., `bridge_1.txt`) located in `benchmarks/`.

The program calculates and displays the maximum flow, execution time, and flow distribution.

---

### 🔗 Input File Format
- First line: Number of nodes in the graph.
- Subsequent lines: Edges with format:

    ```
    from_node to_node capacity
    ```

---

## 🔥 Features
- Calculates the maximum flow from source to sink.
- Displays:
  - Total maximum flow.
  - Flow across each edge.
  - Execution time in milliseconds.
- Supports multiple input files from the `benchmarks/` folder.

---

## 🧠 Algorithm Used
- Ford-Fulkerson Algorithm with BFS (Edmonds-Karp variant)
- Finds augmenting paths using BFS.
- Updates forward and reverse edges using the residual graph.
- Stops when no more augmenting paths are available.

---

## 📂 Technologies Used
- Java
- File handling (BufferedReader)
- Data structures:
  - Adjacency list (ArrayList)
  - Queue for BFS
  - HashMap for path tracking

---

## 🚀 Project Structure

| File              | Description                         |
|-------------------|-----------------------------------|
| Main.java         | Runs the program (user interaction) |
| Edge.java         | Represents a directed edge with flow |
| FlowNetwork.java  | Builds the graph as adjacency list |
| MaxFlowSolver.java| Contains the max flow algorithm logic |
| NetworkParser.java| Reads input files to build the graph |
| benchmarks/       | Folder with input graph files      |

---

## 💻 Example Usage
```bash
java Main:

Enter the name of the file to run (e.g., bridge_1.txt): bridge_1.txt

Output:

Maximum Flow: 23
Time Taken: 2.34 ms
Detailed edge flows printed



