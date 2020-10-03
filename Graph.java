import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;

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
		ArrayList<Integer> vertices = new ArrayList<Integer>();
		Clique clique;
		boolean completecol;
		long start = System.currentTimeMillis();
		//find k-clique (i.e. a square submatrix of size k where all entries are 1)
		if (k > 1 && k <= numVertex) { //if k is greater than 1, then try to find a k-clique.
			for (int topleft = 0; topleft < numVertex; topleft++) { //start at every point on the main diagonal
				if (topleft + k - 1 < numVertex) { //search for a clique starting at the current top left if there are enough vertices
					vertices.add(topleft);
					completecol = true;
					for (int col = topleft + 1; col != topleft; col++, col%=numVertex) {
						for (int row : vertices) {
							if (adjMatrix[row][col] == 0) {
								completecol = false;
								break;
							} 
						}
						if (completecol) { //if we looked down the column and found all 1's then add it
							vertices.add(col);
						}
						if (vertices.size() == k) break; //this means we have found a cliuqe so stop looking
						completecol = true;
					}
					if (vertices.size() < k) { //we did not find a clique so try again with a new top left
						vertices.clear();
					} else { //otherwise we found a clique
						break;
					}
				} else { //otherwise there are not enough vertices so do not bother looking for a clique
					break;
				}
			}
		} else if (k == 1) { //if k is 1, then just return the first vertex.
			vertices.add(0);
		}
		long end = System.currentTimeMillis();
		long ms = end - start;
		if (vertices.size() > 0) {
			Collections.sort(vertices);
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