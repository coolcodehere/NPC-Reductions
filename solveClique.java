import java.util.*;
import java.time.LocalTime;

public class solveClique {


  public static void main(String args[]) {
    String graphFilename = "graphs2020.txt";
    GraphParser gr = new GraphParser(graphFilename);
    ArrayList<Graph> graphs = gr.getGraphs();

    for (int i = 0; i < graphs.size(); i++) {
      System.out.print("G" + (i+1) + " ");

      Clique clique = new Clique(graphs.get(i));
      List<Integer> maxClique = clique.findMaxClique();
      System.out.print(formatClique(maxClique) + " ");
      System.out.println("(size=" + maxClique.size() + ", " + clique.ms + " ms)");
    }
  }

  public static String formatClique(List<Integer> clique) {
    String out = "{";
    String cliqueArray = Arrays.toString(clique.toArray());
    out += cliqueArray.substring(1, cliqueArray.length() - 1);
    out += "}";
    return out;
  }

}
