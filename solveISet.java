import java.util.ArrayList;

public class solveISet {
	public static void main(String[] args) {
		if (args.length < 1) {
            System.out.println("Usage: solveClique graphFile");
            return;
        }
        String filename = args[0];
		ArrayList<Graph> graphs = new GraphParser(filename).getGraphs();
		ArrayList<Clique> cliques = new ArrayList<Clique>();

		for (Graph graph : graphs) {
			cliques.add(new Clique(graph.getCompliment()));
		}

		System.out.println("* Max Independent Sets in graphs in " + filename + ": (reduced to K-Clique) *");
		System.out.println("   (|V|,|E|) Independent Set (size, ms used)");
		for (int i = 0; i < graphs.size(); i++) {
			cliques.get(i).findMaxClique();
			System.out.println("G" + (i + 1) + " " + graphs.get(i).toString() + " " + cliques.get(i).toString());
		}
		System.out.println("***");
	}
}