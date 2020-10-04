import java.sql.SQLOutput;
import java.util.*;
import java.lang.*;

public class Clique {
  //Current max clique
  List<Integer> max = new ArrayList<>();
  List<List<Integer>> cliques = new ArrayList<>();
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
      bronKerbosh(p, new HashSet<>(), new HashSet<>(), -1);
      ms =  System.currentTimeMillis() - ms;
    return max;
  }

  public List<List<Integer>> findKClique(int n) {
    Set<Integer> p = new HashSet<>();
    for (int i = 0; i < graph.size; i++) {
      p.add(i);
    }
    bronKerbosh(p, new HashSet<>(), new HashSet<>(), n);
    ms =  System.currentTimeMillis() - ms;
    return cliques;
  }

  public void bronKerbosh(Set<Integer> p, Set<Integer> r, Set<Integer> x, int n) {
    if (union(p, x).isEmpty()) {
      if (r.size() == n) {
        cliques.add(setToList(r));
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

      bronKerbosh(intersect(p, neighbors(v)), newR, intersect(x, neighbors(v)), n);
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
