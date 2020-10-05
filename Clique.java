import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Clique {
  private List<Integer> max = new ArrayList<>();
  private List<Integer> kClique = new ArrayList<>();
  private long ms;
  private Graph graph;

  /***********CONSTRUCTORS***********/
  public Clique(Graph g) {
    graph = g;
  }

  /***********PUBLIC METHODS***********/
  public List<Integer> findMaxClique() {
    long start = System.currentTimeMillis();
    Set<Integer> p = new HashSet<>();
    for (int i = 0; i < graph.getNumVertex(); i++) {
      p.add(i);
    }
    bronKerbosh(p, new HashSet<>(), new HashSet<>(), -1, 0);
    long end = System.currentTimeMillis();
    ms =  end - start;
    Collections.sort(max);
    return max;
  }

  public List<Integer> findKClique(int n) {
    long start = System.currentTimeMillis();
    Set<Integer> p = new HashSet<>();
    for (int i = 0; i < graph.getNumVertex(); i++) {
      p.add(i);
    }
    bronKerbosh(p, new HashSet<>(), new HashSet<>(), n, System.currentTimeMillis());
    long end = System.currentTimeMillis();
    ms =  end - start;
    Collections.sort(kClique);
    return kClique;
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
  private boolean bronKerbosh(Set<Integer> p, Set<Integer> r, Set<Integer> x, int n, long startTime) {
    if (System.currentTimeMillis() - startTime >= 500 && n != -1) {
      return true;
    }
    if (union(p, x).isEmpty()) {
      if (n != -1 && r.size() == n) {
        kClique.addAll(r);
        return true;
      }

      if (r.size() > max.size()) {
        max = setToList(r);
      }
    }

    Object[] pArr = p.toArray();
    for (Object vTemp : pArr) {
      int v = (int)vTemp;

      Set<Integer> newR = new HashSet<>();
      newR.addAll(r);
      newR.add(v);

      if (bronKerbosh(intersect(p, neighbors(v)), newR, intersect(x, neighbors(v)), n, startTime)) {
        return true;
      }
      p.remove(v);
      x.add(v);
    }
    return false;
  }

  private Set<Integer> union(Set<Integer> a, Set<Integer> b) {
    Set<Integer> unionSet = new HashSet<>();
    unionSet.addAll(a);
    unionSet.addAll(b);
    return unionSet;
  }

  private List<Integer> setToList(Set<Integer> set) {
    List<Integer> out = new ArrayList<>();
    out.addAll(set);
    return out;
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
