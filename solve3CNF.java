import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class solve3CNF {
  public static void main(String args[]) {
    String cnfFilename = "cnfs2020.txt";
    CNFParser cnfParser = new CNFParser(cnfFilename);
    ArrayList<CNF> cnfs = cnfParser.getCNFS();

    for (int i = 0; i < cnfs.size(); i++) {
      CNFToGraph cnfToGraph = new CNFToGraph(cnfs.get(i));
      Clique clique = new Clique(cnfToGraph.convertClique());
      clique.findKClique(cnfs.get(i).numClauses);
      CNF currCNF = cnfs.get(i);
      int k = currCNF.numClauses;
      int n = currCNF.numTerms;

      List<Integer> result = new ArrayList<>();
      for(List<Integer> pClique : clique.cliques) {
        if (pClique.size() == k) {
          result = pClique;
          break;
        }
      }

      List<Integer> resultVals = new ArrayList<>();

      for (int num : result) {
        resultVals.add(currCNF.cnfVals.get(num));
      }
      List<Integer> unique = new ArrayList<Integer>(new HashSet<Integer>(resultVals));
      String out = "";
      for (int val : unique) {
        if (val > 0) {
          out += "T,";
        } else {
          out += "F,";
        }
      }
      if (result.isEmpty()) {
        System.out.printf("3CNF No.%d:[n=%d k=%d] No %d-clique; no solution (%d ms)\n", (i+1), n, k, k, clique.ms);
      } else {
        System.out.printf("3CNF No.%d:[n=%d k=%d] %s(%d ms)\n", (i+1), n, k, out, clique.ms);
      }

    }
  }
}
