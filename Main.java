import java.sql.SQLOutput;
import java.util.*;
import java.io.File;

class Main {
  public static void main(String[] args) {
		String cnfFilename = "cnfs2020.txt";
		CNFParser cnfParser = new CNFParser(cnfFilename);
		ArrayList<CNF> cnfs = cnfParser.getCNFS();

		cnfs.get(6).printCNF();
  }

}