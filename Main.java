import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
	String filename = "graphs2020.txt";
    GraphParser gr = new GraphParser(filename);
	ArrayList<Graph> graphs = gr.getGraphs();

	// for (Graph graph : graphs) {
	// 	System.out.println(graph.toString());
	// 	graph.printAdjMatrix();
	// 	System.out.println();
	// }
	System.out.println(graphs.get(0).toString());
	graphs.get(0).printAdjMatrix();
  }
}