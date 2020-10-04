import java.lang.reflect.Array;
import java.util.ArrayList;

public class solve3CNF {
    public static void main(String args[]) {
        String cnfFilename = "cnfs2020.txt";
        CNFParser cnfParser = new CNFParser(cnfFilename);
        ArrayList<CNF> cnfs = cnfParser.getCNFS();

        for (CNF cnf : cnfs) {
            CNFToGraph cnfToGraph = new CNFToGraph(cnf);
            Clique clique = new Clique(cnfToGraph.convertClique());
            clique.findMaxClique();
        }
    }
}
