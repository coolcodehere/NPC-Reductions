import java.util.ArrayList;

public class solveClique {
    public static void main(String[] args) {
        if (args.length < 1) {
            return;
        }
        String filename = args[0];
        ArrayList<Graph> graphs = new GraphParser(filename).getGraphs();
        ArrayList<Graph> cliques = new ArrayList<Graph>();

    }
}
