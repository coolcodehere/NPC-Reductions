import java.util.*;

public class Clique {
  //Current max clique
  List<Integer> max = new ArrayList<>();
  Graph graph;

  public Clique(Graph graph) {
    this.graph = graph;
  }

  public List<Integer> findMaxClique() {
      Set<Integer> r = new HashSet<>();
      Set<Integer> p = new HashSet<>();
      Set<Integer> x = new HashSet<>();
      for (int i = 0; i < graph.size; i++) {
        p.add(i);
      }
      bronKerbosh(p, r, x);

    System.out.println(graph.size + ": " + max.size() + " " + Arrays.toString(max.toArray()));
    return max;
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
        if (makesNewClique(graph, newClique, i)) {
          maxClique(graph, newClique);
        }
      }
    }
  }

  public void bronKerbosh(Set<Integer> p, Set<Integer> r, Set<Integer> x) {
//    System.out.println("r: " + Arrays.toString(r.toArray()));
//    System.out.println("p: " + Arrays.toString(p.toArray()));
//    System.out.println("x: " + Arrays.toString(x.toArray()));
//    System.out.println("max: " + Arrays.toString(max.toArray()));


    if (x.isEmpty() && p.isEmpty() && r.size() > max.size()) {
//      System.out.println("TRUE");

      max = new ArrayList<>();
      max.addAll(r);
      //max clique
    }

    Object[] pArr = p.toArray();
    for (Object vTemp : pArr) {
      int v = (int)vTemp;

      Set<Integer> newR = new HashSet<>();
      newR.addAll(r);
      newR.add(v);

      bronKerbosh(intersect(p, neighbors(v)), newR, intersect(x, neighbors(v)));
      p.remove(v);
      x.add(v);
    }
  }

  private Set<Integer> union(Set<Integer> a, Set<Integer> b) {
    Set<Integer> unionSet = new HashSet<>();
    unionSet.addAll(a);
    unionSet.addAll(b);
    return unionSet;
  }

  public Set<Integer> intersect(Set<Integer> a, Set<Integer> b) {
    Set<Integer> intersectSet = new HashSet<>();

    for (int num : a) {
      if (b.contains(num)) {
        intersectSet.add(num);
      }
    }

    for (int num : b) {
      if (a.contains(num)) {
        intersectSet.add(num);
      }
    }

    return intersectSet;
  }

  private Set<Integer> neighbors(int node) {
    Set<Integer> neighbors = new HashSet<>();
    for (int i = 0; i < graph.size; i++) {
      if (graph.matrix[node][i] == 1 && i != node) {
        neighbors.add(i);
      }
    }
    return neighbors;
  }

  private boolean makesNewClique(Graph graph, List<Integer> clique, int newNode) {
    for (int node : clique) {
      if (graph.matrix[node][newNode] == 0) {
        return false;
      }
    }
    return true;
  }

  private boolean isClique(Graph graph, List<Integer> clique, int newNode) {
    for (int node : clique) {
      if (graph.matrix[node][newNode] == 0) {
        return false;
      }
    }
    return true;
  }
}
