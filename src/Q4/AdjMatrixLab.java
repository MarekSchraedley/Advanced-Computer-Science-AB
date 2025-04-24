package Q4;

import DataStructures.Dictionary;
import DataStructures.GraphMatrix;

import java.util.Arrays;

public class AdjMatrixLab {
    public static <T extends Comparable<T>> void colorGraph(GraphMatrix<T> graph) {
        int vCount = graph.getVertexCount();
        int[][] matrix = graph.getMatrix();
        Dictionary<T, Integer> verticies = graph.getVertices();
        int[] result = new int[vCount];
        Arrays.fill(result, -1);

        result[0] = 0;
        boolean[] available = new boolean[vCount];
        for (int u = 0; u < vCount; u++) {
            Arrays.fill(available, true);
            for (int v = 0; v < vCount; v++) {
                if (matrix[u][v] != 0 && result[v] != -1) {
                    available[result[v]] = false;
                }
            }
            int color;
            for (color = 0; color < vCount; color++) {
                if (available[color]) break;
            }
            result[u] = color;
        }

        System.out.println("Vertex colors:");
        for (int i = 0; i < vCount; i++) {
            System.out.println("Vertex " + verticies.getKey(i) + " --> Color " + result[i]);
        }
    }

    public static void main(String[] args) {
        var graph = new GraphMatrix<String>(6);

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("B", "D");
        graph.addEdge("B", "F");
        graph.addEdge("C", "E");
        graph.addEdge("C", "F");
        graph.addEdge("E", "F");

        graph.display();
        System.out.println();

        colorGraph(graph);
    }
}
