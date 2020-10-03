import java.util.*;
import java.time.LocalTime;

public class solveClique {
    public static void main(String args[]) {
        String graphFilename = "graphs2020.txt";
        GraphParser gr = new GraphParser(graphFilename);
        ArrayList<Graph> graphs = gr.getGraphs();
        System.out.println(graphs.size());
        for (Graph graph : graphs) {
            System.out.println(LocalTime.now());
            findMaxClique(graph);
        }

        findMaxClique(graphs.get(0));
    }

    public static void findMaxClique(Graph graph) {
        List<Integer> nodes = getNodeSet(graph);
        List<List<Integer>> set = powerSet(nodes);
        Collections.sort(set, Comparator.comparing(List::size));
        List<Integer> max = maxClique(graph, set);
        System.out.print("Size " + graph.size + ": ");
        for(Integer num : max) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Get the array of every node in the graph.
    public static List<Integer> getNodeSet(Graph graph) {
        ArrayList<Integer> nodeSet = new ArrayList<>();
        for (int i = 0; i < graph.size; i++) {
            nodeSet.add(i);
        }
        return nodeSet;
    }

    public static List<Integer> maxClique(Graph graph, List<List<Integer>> powerSet) {
        List<Integer> max = new ArrayList<>();

        for (int i = powerSet.size() - 1; i >= 0; i--) {
            if (isClique(powerSet.get(i), graph)) {
                max = powerSet.get(i);
                break;
            }
        }

        return max;
    }

    public static boolean isClique(List<Integer> set, Graph graph) {
        Object[] nodes = set.toArray();
        for (Object i : nodes) {
            for (Object j : nodes) {
                if (i != j && graph.matrix[(int)i][(int)j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static <T> List<List<T>> powerSet(List<T> input) {
        List<List<T>> sets = new ArrayList<>();
        for (T element : input) {
            for (ListIterator<List<T>> setsIterator = sets.listIterator(); setsIterator.hasNext(); ) {
                List<T> newSet = new ArrayList<>(setsIterator.next());
                newSet.add(element);
                setsIterator.add(newSet);
            }
            sets.add(new ArrayList<>(Arrays.asList(element)));
        }
        sets.add(new ArrayList<>());
        return sets;
    }
}
