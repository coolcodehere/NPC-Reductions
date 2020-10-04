import java.util.ArrayList;

public class solve3CNF {
    public static void main(String args[]) {
        // if (args.length < 1) {
        //     return;
        // }
        // String filename = args[0];
        String filename = "cnfs2020.txt";
        ArrayList<CNF> cnfs = new CNFParser(filename).getCNFS();
        ArrayList<CNFToGraph> cnfToGraphs = new ArrayList<CNFToGraph>();
        ArrayList<Clique> cliques = new ArrayList<Clique>();

        for (CNF cnf : cnfs) {
            cnfToGraphs.add(new CNFToGraph(cnf));
        }

        for (CNFToGraph cnfToGraph: cnfToGraphs) {
            cliques.add(new Clique(cnfToGraph.convertClique()));
        }

        System.out.println("* Solve 3CNF in " + filename + ": (reduced to K-Clique) *");
        System.out.println("                    x: can be either T or F");
        for (int i = 0; i < cnfs.size(); i++) {
            System.out.println("3CNF No."+ (i+1) + ":" + (i + 1) + " " + cnfToGraphs.get(i).toString() + " " + cliques.get(i).toString());
        }
        System.out.println("***");
    }
}
