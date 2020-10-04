import java.sql.SQLOutput;
import java.util.*;
import java.io.File;

class Main {
  public static void main(String[] args) {
		String cnfFilename = "cnfs2020.txt";
		CNFParser cnfParser = new CNFParser(cnfFilename);
		ArrayList<CNF> cnfs = cnfParser.getCNFS();
		CNFToGraph cnfToGraph = new CNFToGraph(cnfs.get(0));
		Clique clique = new Clique(cnfToGraph.convertClique());
  }

}