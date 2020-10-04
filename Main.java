import java.sql.SQLOutput;
import java.util.*;
import java.io.File;

class Main {
  public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(1,2);
		g.addEdge(1,3);
		Clique c = new Clique(g);
		c.findMaxClique();
  }

}