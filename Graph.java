public class Graph {
	private int numVertex;
	private int numEdges;
	private int[][] adjMatrix;

	/***********CONSTRUCTORS***********/
	public Graph(int numV) {
		numVertex = numV;
		numEdges = 0;
		adjMatrix = new int[numV][numV];
	}

	public Graph(int numV, int numE, int[][] matrix) {
		numVertex = numV;
		numEdges = numE;
		adjMatrix = matrix;
	}

	public Graph(Graph copy) {
		numVertex = copy.numVertex;
		numEdges = copy.numEdges;
		adjMatrix = copy.adjMatrix;
	}
	
	/***********METHODS***********/
	public void addEdge(int fromIndex, int toIndex) {
		adjMatrix[fromIndex][toIndex] = 1;
		adjMatrix[toIndex][fromIndex] = 1;
		numEdges++;
	}

	public void removeEdge(int fromIndex, int toIndex) {
		adjMatrix[fromIndex][toIndex] = 0;
		adjMatrix[toIndex][fromIndex] = 0;
		numEdges--;
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

	public Graph getCompliment() {
		Graph comp = new Graph(this);
		for (int i = 1; i < numVertex; i++) {
			for (int j = i + 1; j < numVertex; j++) {
			  if (adjMatrix[i][j] == 0) {
				addEdge(i, j);
			  } else {
				removeEdge(i, j);
			  }
			}
		  }
		return comp;
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