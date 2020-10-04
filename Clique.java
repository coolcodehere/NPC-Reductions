import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Clique {
  List<Integer> max = new ArrayList<>();
  long ms = System.currentTimeMillis();
  Graph graph;

  /***********CONSTRUCTORS***********/
  public Clique(Graph graph) {
    this.graph = graph;
    findMaxClique();
  }

  /***********PUBLIC METHODS***********/
  public List<Integer> findMaxClique() {
      Set<Integer> r = new HashSet<>();
      Set<Integer> p = new HashSet<>();
      Set<Integer> x = new HashSet<>();
      for (int i = 0; i < graph.getNumVertex(); i++) {
        p.add(i);
      }
      bronKerbosh(p, r, x);
      ms =  System.currentTimeMillis() - ms;
    return max;
  }

  public String toString() {
    String temp = "{";
    for (int vertex : max) {
        temp += vertex + ",";
    }
    temp += "\b} (size=" + max.size() + ", ms=" + ms + ")";
    return temp;
  }

  /***********PRIVATE METHODS***********/
  public void bronKerbosh(Set<Integer> p, Set<Integer> r, Set<Integer> x) {
    if (union(p, x).isEmpty() && r.size() > max.size()) {
      max = new ArrayList<>();
      max.addAll(r);
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
    for (int i = 0; i < graph.getNumVertex(); i++) {
      if (graph.getAdjMatrix()[node][i] == 1 && i != node) {
        neighbors.add(i);
      }
    }
    return neighbors;
  }

  private boolean makesNewClique(Graph graph, List<Integer> clique, int newNode) {
    for (int node : clique) {
      if (graph.getAdjMatrix()[node][newNode] == 0) {
        return false;
      }
    }
    return true;
  }

  private boolean isClique(Object[] clique) {
    for (Object i : clique) {
      for (Object j : clique) {
        if (graph.getAdjMatrix()[(int)i][(int)j] != 1 && i != j) {
          return false;
        }
      }
    }
    return true;
  }
}
