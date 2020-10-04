public class Graph {
	private int numVertex;
	private int numEdges;
	private int[][] adjMatrix;

	/***********CONSTRUCTORS***********/
	public Graph(int numV) {
		numVertex = numV;
		adjMatrix = new int[numV][numV];
	}
	public Graph(int numV, int numE, int[][] matrix) {
		numVertex = numV;
		numEdges = numE;
		adjMatrix = matrix;
	}
	
	/***********METHODS***********/
	public void addEdge(int fromIndex, int toIndex) {
		adjMatrix[fromIndex][toIndex] = 1;
		adjMatrix[toIndex][fromIndex] = 1;
	}

	public void removeEdge(int fromIndex, int toIndex) {
		adjMatrix[fromIndex][toIndex] = 0;
		adjMatrix[toIndex][fromIndex] = 0;
	}
	
	public String toString() {
		return "(" + numVertex + ", " + numEdges + ")";
	}

	public void printAdjMatrix() {
		for (int row = 0; row < numVertex; row++) {
			for (int col = 0; col < numVertex; col++) {
				System.out.print(adjMatrix[row][col] + " ");
			}
			System.out.println();
		}
	}

	/***********GETTERS***********/
	public int getNumEdges() {
		return numEdges;
	}

	public int getNumVertex() {
		return numVertex;
	}

	public int[][] getAdjMatrix() {
		return adjMatrix;
	}
}