package DataStructures;

/**
 * Underected Weighted Adjacency Matrix
 */
public class GraphMatrix<T extends Comparable<T>> implements Graph<T> {
    private final Dictionary<T, Integer> vertecies;
    private final int[][] matrix;
    private int vertexCount;
    public GraphMatrix(int size) {
        vertecies = new Dictionary<>();
        matrix = new int[size][size];
        vertexCount = 0;
    }
    @Override
    public void addVertex(T vertex) {
        if (!vertecies.containsKey(vertex))
            vertecies.insert(vertex, vertexCount);
    }

    @Override
    public void addEdge(T source, T destination) {
        addEdge(source, destination, 1);
    }

    public void addEdge(T source, T destination, int weight) {
        int sourceIndex = vertecies.get(source);
        int destinationIndex = vertecies.get(destination);
        matrix[sourceIndex][destinationIndex] = weight;
        matrix[destinationIndex][sourceIndex] = weight;
    }

    public void addDirectedEdge(T source, T destination) {
        addDirectedEdge(source, destination, 1);
    }

    public void addDirectedEdge(T source, T destination, int weight) {
        int sourceIndex = vertecies.get(source);
        int destinationIndex = vertecies.get(destination);
        matrix[sourceIndex][destinationIndex] = weight;
    }

    @Override
    public void removeVertex(T vertex) {
        if (!vertecies.containsKey(vertex)) return;
        int index = vertecies.get(vertex);
        for (int i = 0; i < vertexCount; i++) {
            matrix[i][index] = 0;
            matrix[index][i] = 0;
        }
        vertecies.remove(vertex);
        vertexCount--;
    }

    @Override
    public void removeEdge(T source, T destination) {
        int sourceIndex = vertecies.get(source);
        int destinationIndex = vertecies.get(destination);
        matrix[sourceIndex][destinationIndex] = 0;
        matrix[destinationIndex][sourceIndex] = 0;
    }

    public void removeDirectedEdge(T source, T destination) {
        int sourceIndex = vertecies.get(source);
        int destinationIndex = vertecies.get(destination);
        matrix[sourceIndex][destinationIndex] = 0;
    }

    @Override
    public boolean hasVertex(T vertex) {
        return vertecies.containsKey(vertex);
    }

    @Override
    public boolean hasEdge(T source, T destination) {
        int sourceIndex = vertecies.get(source);
        int destinationIndex = vertecies.get(destination);
        return matrix[sourceIndex][destinationIndex] != 0;
    }

    @Override
    public void display() {
        System.out.println("Verticies:");
        vertecies.enumerate();
        System.out.println("Matrix:");
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                System.out.println(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }



    public int getEdgeWeight(T source, T destination) {
        int sourceIndex = getVertices().get(source);
        int destinationIndex = vertecies.get(destination);
        return matrix[sourceIndex][destinationIndex];
    }

    public Dictionary<T, Integer> getVertices() {return vertecies;}
    public int[][] getMatrix() {return matrix;}
    public int getVertexCount() {return vertexCount;}

    public DynamicArray<T> getNeighbors(T vertex) {
        DynamicArray<T> neighbors = new DynamicArray<>();
        int index = vertecies.get(vertex);
        for (int i = 0; i < vertexCount; i++) {
            if (matrix[index][i] != 0) {
                neighbors.add(vertecies.getKey(i));
            }
        }
        return neighbors;
    }
}
