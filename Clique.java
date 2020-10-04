import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Clique {
  //Current max clique
  List<Integer> max = new ArrayList<>();
  Graph graph;

  public Clique(Graph graph) {
    this.graph = graph;
  }

  public void findMaxClique() {
    max = new ArrayList<>();
    //don't check nodes with degree of 1
    for (int i = 0; i < graph.size; i++) {
      List<Integer> clique = new ArrayList<>();
      clique.add(i);
      maxClique(graph, clique);
    }

    System.out.println(graph.size + ": " + max.size() + " " + Arrays.toString(max.toArray()));
  }

  // MEAT HERE
  private void maxClique(Graph graph, List<Integer> clique) {
    //Get the newest node added to the clique
    int currentValue = clique.get(clique.size() - 1);

    if (clique.size() > max.size()) {
      max = clique;
    }

    // Check every node
    for (int i = 0; i < graph.size; i++) {

      // If the node being checked is connected to the current node, and isn't the current node
      if (graph.matrix[currentValue][i] == 1 && !clique.contains(i)) {
        //Check if the new clique is bigger than the current max.


        //Make a new clique and add all the nodes from the current clique to it
        ArrayList<Integer> newClique = new ArrayList<>();
        newClique.addAll(clique);
        //Add the new node
        newClique.add(i);

        //Repeat
        if (makesNewClique(graph, clique, i)) {
          maxClique(graph, newClique);
        }
      }
    }
  }


  private boolean makesNewClique(Graph graph, List<Integer> clique, int newNode) {
    for (int node : clique) {
      if (graph.matrix[node][newNode] == 0) {
        return false;
      }
    }
    return true;
  }
}
