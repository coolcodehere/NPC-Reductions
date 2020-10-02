import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
	String graphFilename = "graphs2020.txt";
    GraphParser gr = new GraphParser(graphFilename);
	ArrayList<Graph> graphs = gr.getGraphs();

	String cnfFilename = "cnfs2020.txt";
	CNFParser cnf = new CNFParser(cnfFilename);
	ArrayList<CNF> cnfs = cnf.getCNFS();
	
	cnfs.get(0).printCNF();
  }

}