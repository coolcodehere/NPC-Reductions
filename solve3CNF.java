import java.util.ArrayList;
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

      List<Integer> result = new ArrayList<>();
      for(List<Integer> pClique : clique.cliques) {
        if (pClique.size() == cnfs.get(i).numClauses) {
          result = pClique;
          break;
        }
      }

      if (result.isEmpty()) {
        System.out.printf("3CNF No.%d:[n=%d k=%d] No %d-clique; no solution (%d ms)\n", (i+1), cnfs.get(i).numClauses, cnfs.get(i).numClauses * cnfs.get(i).numTerms, cnfs.get(i).numClauses, clique.ms);
      } else {
        System.out.printf("3CNF No.%d:[n=%d k=%d] %s(%d ms)\n",i,cnfs.get(i).numClauses, cnfs.get(i).numClauses * cnfs.get(i).numTerms, "PLACEHOLDER", clique.ms);
      }

    }
  }
}
