import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.lang.Integer;

// This class exists to parse the input file and generate an arraylist of graphs from it. 
class GraphParser {
	private ArrayList<Graph> graphArray = new ArrayList<Graph>();
	private File graphFile;

	public GraphParser(String graphFileName) {
		this.graphFile = new File(graphFileName);
		readGraph();
	}

	private void readGraph() {
		Scanner scan = null;
		try {
			scan = new Scanner(graphFile);
		} catch (Exception e) {

		}
		
		// Since the first line is known to be a size, get the first line here. 
		int size = Integer.parseInt(scan.nextLine());
		String data = "";

		// Gathers graph data, builds graph, and sends new graph to graphArray.
		while (scan.hasNextLine()) {
			String line = scan.nextLine();

			if(line.matches("\\d+")) {
				Graph graph = new Graph(size, buildMatrix(size, data));
				graphArray.add(graph);

				size = Integer.parseInt(line);
				data = "";
			} else {
				data += line + "\n";
			}
		}
		
	}

	private int[][] buildMatrix(int size, String data) {
		int[][] matrix = new int[size][size];
		String[] lines = data.split("\n");

		for (int i = 0; i < size; i++) {
			String[] edges = lines[i].split(" ");
			for (int j = 0; j < size; j++) {
				matrix[i][j] = Integer.parseInt(edges[j]);
			}
		}
		return matrix;
	}

	// Retrieves graph array from the parser. 
	public ArrayList<Graph> getGraphs() {
		return graphArray;
	}
}