class Graph {
	private int numVertex;
	private int numEdges;
	private int[][] adjMatrix;

	/***********CONSTRUCTORS***********/
	public Graph() {
		numVertex = 0;
		numEdges = 0;
		adjMatrix = null;
	}

	public Graph(int numV, int numE, int[][] matrix) {
		numVertex = numV;
		numEdges = numE;
		adjMatrix = matrix;
	}	

	/***********METHODS***********/
	public Graph findClique() {
		return new Graph();
	}

	public String toString() {
		return "(" + numVertex + ", " + numEdges + ")";
	}

	public void printGraph() {
		System.out.println(toString());
		for (int i = 0; i < numVertex; i++) {
			for (int j = 0; j < numVertex; j++) {
				System.out.print(adjMatrix[i][j] + " ");
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