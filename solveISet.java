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
    for (int i = 0; i < graph.size; i++) {
      for (int j = 0; j < graph.size; j++) {
        if (graph.matrix[i][j] == 0) {
          graph.matrix[i][j] = 1;
        } else {
          graph.matrix[i][j] = 0;
        }
      }
    }
  }
}