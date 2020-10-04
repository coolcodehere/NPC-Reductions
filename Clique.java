import java.sql.SQLOutput;
import java.util.*;
import java.lang.*;

public class Clique {
  //Current max clique
  List<Integer> max = new ArrayList<>();
  List<Integer> kClique = new ArrayList<>();
  long ms = System.currentTimeMillis();
  Graph graph;

  public Clique(Graph graph) {
    this.graph = graph;
  }

  public List<Integer> findMaxClique() {
      Set<Integer> p = new HashSet<>();
      for (int i = 0; i < graph.size; i++) {
        p.add(i);
      }
      bronKerbosh(p, new HashSet<>(), new HashSet<>(), -1, 0);
      ms =  System.currentTimeMillis() - ms;
    return max;
  }

  public List<Integer> findKClique(int n) {
    Set<Integer> p = new HashSet<>();
    for (int i = 0; i < graph.size; i++) {
      p.add(i);
    }
    bronKerbosh(p, new HashSet<>(), new HashSet<>(), n, System.currentTimeMillis());
    ms =  System.currentTimeMillis() - ms;
    return kClique;
  }

  public boolean bronKerbosh(Set<Integer> p, Set<Integer> r, Set<Integer> x, int n, long startTime) {
    if (System.currentTimeMillis() - startTime > 10000 && n != -1) {
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
    for (int i = 0; i < graph.size; i++) {
      if (graph.matrix[node][i] == 1 && i != node) {
        neighbors.add(i);
      }
    }
    return neighbors;
  }
}
