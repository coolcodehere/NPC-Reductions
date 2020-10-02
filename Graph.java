import java.util.Scanner;
import java.io.File;

class Graph {
	public int size;
	public int[][] matrix;

	public Graph(int size, int[][] matrix) {
		this.size = size;
		this.matrix = matrix;
	}

	public Graph(int size) {
		this.size = size;
		this.matrix = new int[size][size];
	}

	public void addEdge(int fromIndex, int toIndex) {
		matrix[fromIndex][toIndex] = 1;
		matrix[toIndex][fromIndex] = 1;
	}

	public void removeEdge(int fromIndex, int toIndex) {
		matrix[fromIndex][toIndex] = 0;
		matrix[toIndex][fromIndex] = 0;
	}

	public void printGraph() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}