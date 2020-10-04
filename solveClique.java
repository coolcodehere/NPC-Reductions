import java.util.*;
import java.time.LocalTime;

public class solveClique {


  public static void main(String args[]) {
    String graphFilename = "graphs2020.txt";
    GraphParser gr = new GraphParser(graphFilename);
    ArrayList<Graph> graphs = gr.getGraphs();

    System.out.print(LocalTime.now());
    for (int i = 0; i < graphs.size(); i++) {

      System.out.print("(" + i + ")");
      Clique clique = new Clique(graphs.get(i));
      clique.findMaxClique();
    }
    System.out.print(LocalTime.now());
  }

}
