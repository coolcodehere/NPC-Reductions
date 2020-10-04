import java.util.*;
import java.lang.*;

public class Clique {
  //Current max clique
  List<Integer> max = new ArrayList<>();
  long ms = System.currentTimeMillis();
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
      ms =  System.currentTimeMillis() - ms;
    return max;
  }

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

  private boolean isClique(Object[] clique) {
    for (Object i : clique) {
      for (Object j : clique) {
        if (graph.matrix[(int)i][(int)j] != 1 && i != j) {
          return false;
        }
      }
    }
    return true;
  }
}
