import java.time.LocalTime;
import java.util.ArrayList;

class solveISet {
  public static void main(String[] args) {
    String graphFilename = "graphs2020.txt";
    GraphParser gr = new GraphParser(graphFilename);
    ArrayList<Graph> graphs = gr.getGraphs();

    System.out.print(LocalTime.now());
    for (int i = 0; i < graphs.size(); i++) {

      invertGraph(graphs.get(i));
      Clique clique = new Clique(graphs.get(i));
      clique.findMaxClique();
    }
    System.out.print(LocalTime.now());
  }

  public static void invertGraph(Graph graph) {
    for (int i = 0; i < graph.getNumVertex(); i++) {
      for (int j = 0; j < graph.getNumVertex(); j++) {
        if (graph.getAdjMatrix()[i][j] == 0) {
          graph.getAdjMatrix()[i][j] = 1;
        } else {
          graph.getAdjMatrix()[i][j] = 0;
        }
      }
    }
  }
}