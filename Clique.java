import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Clique {
  private List<Integer> max = new ArrayList<>();
  private long ms;
  private Graph graph;

  /***********CONSTRUCTORS***********/
  public Clique(Graph g) {
    graph = g;
  }

  /***********PUBLIC METHODS***********/
  public List<Integer> findMaxClique() {
    long start = System.currentTimeMillis();
    Set<Integer> r = new HashSet<>();
    Set<Integer> p = new HashSet<>();
    Set<Integer> x = new HashSet<>();
    for (int i = 0; i < graph.getNumVertex(); i++) {
      p.add(i);
    }
    bronKerbosh(p, r, x);
    long end = System.currentTimeMillis();
    ms =  end - start;
    Collections.sort(max);
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

  private Set<Integer> intersect(Set<Integer> a, Set<Integer> b) {
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

  /***********GETTERS***********/
  public List<Integer> getMax() {
    return max;
  }

  public long getMS() {
    return ms;
  }

  public Graph getGraph() {
    return graph;
  }
}
