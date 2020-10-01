import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.Set;

public class Graph {
	private int numVertex;
	private int numEdges;
	private int[][] adjMatrix;

	/***********CONSTRUCTORS***********/
	public Graph(int numV, int numE, int[][] matrix) {
		numVertex = numV;
		numEdges = numE;
		adjMatrix = matrix;
	}	

	/***********METHODS***********/
	public Clique findFirstKClique(int k) throws InvalidParameterException{
        if (k <= 0) {
			throw new InvalidParameterException();
		}
		Set<String> vertices = new HashSet<String>();
		Clique clique;
		int bottomright;
		boolean complete;
		long start = System.currentTimeMillis();
		//find k-clique (i.e. a square submatrix of size k where all entries are 1)
		if (k > 1 && k <= numVertex) { //if k is greater than 1, then try to find a k-clique.
			for (int topleft = 0; topleft < numVertex; topleft++) {
				bottomright = topleft + k - 1;
				complete = true;
				if (bottomright < numVertex) {
					vertices.add(String.valueOf(topleft));
					for (int row = topleft; row < bottomright; row++) {
						for (int col = row + 1; col <= bottomright; col++) {
							if (adjMatrix[row][col] == 0) {
								complete = false;
								break;
							}
							vertices.add(String.valueOf(col));
						}
						if (!complete) {
							vertices.clear();
							break;
						}
					}
					if (complete) break;
				} else {
					break;
				}
			}
		} else if (k == 1) { //if k is 1, then just return the first vertex.
			vertices.add("0");
		}
		long end = System.currentTimeMillis();
		long ms = end - start;
		if (vertices.size() > 0) {
			clique = new Clique(vertices, ms);
		} else { //otherwise k is greater than numVertex, so return null
			clique = null;
		}
		return clique;
    }
    
    public Clique findMaximumClique() {
		Clique oldClique = null;
		Clique newClique = null;
		for (int k = 1; k <= numVertex + 1; k++) {
			oldClique = newClique;
			newClique = findFirstKClique(k);
			if (newClique == null) {
				break;
			}
		}
		return oldClique;
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