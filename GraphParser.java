import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.lang.Integer;

// This class exists to parse the input file and generate an arraylist of graphs from it. 
public class GraphParser {
	private ArrayList<Graph> graphArray;
	private File graphFile;

	public GraphParser(String graphFileName) {
		graphArray = new ArrayList<Graph>();
		graphFile = new File(graphFileName);
		readGraph();
	}

	private void readGraph() {
		Scanner scan = null;
		try {
			scan = new Scanner(graphFile);
		} catch (Exception e) {}
		
		// Since the first line is known to be a size, get the first line here. 
		int numVertex = Integer.parseInt(scan.nextLine());
		String data = "";

		// Gathers graph data, builds graph, and sends new graph to graphArray.
		while (scan.hasNextLine()) {
			String line = scan.nextLine();

			if(line.matches("\\d+")) {
				createGraph(numVertex, data);
				numVertex = Integer.parseInt(line);
				data = "";
			} else {
				data += line + "\n";
			}
		}
	}

	private void createGraph(int numVertex, String data) {
		int[][] matrix = new int[numVertex][numVertex];
		String[] lines = data.split("\n");
		int numEdges = 0;

		for (int row = 0; row < numVertex; row++) {
			String[] edges = lines[row].split(" ");
			for (int col = 0; col < numVertex; col++) {
				matrix[row][col] = Integer.parseInt(edges[col]);
				if (matrix[row][col] == 1 && row < col) {
					numEdges++;
				}
			}
		}
		Graph graph = new Graph(numVertex, numEdges, matrix);
		graphArray.add(graph);
	}

	// Retrieves graph array from the parser. 
	public ArrayList<Graph> getGraphs() {
		return graphArray;
	}
}