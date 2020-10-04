import java.util.ArrayList;

public class solveClique {
    public static void main(String[] args) {
        // if (args.length < 1) {
        //     return;
        // }
        // String filename = args[0];
        String filename = "graphs2020.txt";
        ArrayList<Graph> graphs = new GraphParser(filename).getGraphs();
        ArrayList<Clique> cliques = new ArrayList<Clique>();

        for (Graph graph : graphs) {
            cliques.add(new Clique(graph));
        }

        System.out.println("* Max Cliques in graphs in " + filename);
        System.out.println("   (|V|,|E|) Cliques (size, ms used)");
        for (int i = 0; i < graphs.size(); i++) {
            System.out.println("G" + (i + 1) + " " + graphs.get(i).toString() + " " + cliques.get(i).toString());
        }
        System.out.println("***");
    }
}
