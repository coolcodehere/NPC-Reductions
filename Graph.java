class Graph {
	public int size;
	public int[][] matrix;

	public Graph(int size, int[][] matrix) {
		this.size = size;
		this.matrix = matrix;
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