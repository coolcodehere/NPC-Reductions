import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
	String filename = "graphs2020.txt";
    GraphParser gr = new GraphParser(filename);
	ArrayList<Graph> graphs = gr.getGraphs();

	for (Graph graph : graphs) {
		System.out.println(graph.size);
		graph.printGraph();
		System.out.println()
	}
	
  }
}