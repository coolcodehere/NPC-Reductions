import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class solve3CNF {
    public static void main(String args[]) {
        if (args.length < 1) {
            System.out.println("Usage: solveClique 3CNFFile");
            return;
        }
        String filename = args[0];
        ArrayList<CNF> cnfs = new CNFParser(filename).getCNFS();
        ArrayList<CNFToGraph> cnfToGraphs = new ArrayList<CNFToGraph>();
        ArrayList<Clique> cliques = new ArrayList<Clique>();

        for (CNF cnf : cnfs) {
          cnfToGraphs.add(new CNFToGraph(cnf));
        }

        for (CNFToGraph cnfToGraph: cnfToGraphs) {
          cliques.add(new Clique(cnfToGraph.getGraph()));
        }

        System.out.println("* Solve 3CNF in " + filename + ": (reduced to K-Clique) *");
        for (int i = 0; i < cnfs.size(); i++) {
          List<Integer> kClique = cliques.get(i).findKClique(cnfs.get(i).getNumClauses());
          System.out.print("3CNF No."+ (i+1) + ":" + " " + cnfToGraphs.get(i).toString() + " ");

          List<Integer> resultVals = new ArrayList<>();
          for (int num : kClique) {
            resultVals.add(cnfs.get(i).getCNFVals().get(num));
          }
          List<Integer> unique = new ArrayList<Integer>(new HashSet<Integer>(resultVals));
          String temp = "";
          if (resultVals.isEmpty()) {
            System.out.print("No " + cnfs.get(i).getNumClauses() + "-clique; no solution ");
          } else {
            for (int vertex : unique) {
              if (vertex > 1) {
                temp += "T,";
              } else {
                temp += "F,";
              }
            } 
            temp += "\b";
            System.out.print(temp);
          }

          System.out.println("(" + cliques.get(i).getMS() + " ms)");
        }
        System.out.println("***");
  }
}
