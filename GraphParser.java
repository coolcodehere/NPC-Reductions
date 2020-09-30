import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.lang.Integer;

// This class exists to parse the input file and generate an arraylist of graphs from it. 
class GraphParser {
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
		} catch (Exception e) {

		}
		
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

		for (int i = 0; i < numVertex; i++) {
			String[] edges = lines[i].split(" ");
			for (int j = 0; j < numVertex; j++) {
				matrix[i][j] = Integer.parseInt(edges[j]);
				if (matrix[i][j] == 1 && i != j) {
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