public class CNFToGraph {
    private CNF cnf;
    private Graph graph;
    private int k;

    /***********CONSTRUCTORS***********/
    public CNFToGraph(CNF c) {
        cnf = c;
        graph = convertClique();
        k = cnf.getNumVariables() + (2 * cnf.getNumClauses());
    }

    /***********PUBLIC METHODS***********/

    public String toString() {
        return "[n=" + cnf.getNumVariables() + " k=" + k + "]";
    }

    /***********PRIVATE METHODS***********/
    private Graph convertClique() {
        Graph graph = new Graph(cnf.getNumVariables() * cnf.getNumClauses());

        connectTerms(graph);
        return graph;
    }

    private void connectTerms(Graph graph) {
        for (int i = 0; i < graph.getNumVertex(); i++) {
            int termValue = getCNFValue(i);
            for (int j = 0; j < graph.getNumVertex(); j++) {
                if (isInSameTerm(i, j) || i == j) {
                    continue;
                }

                if (termValue != getCNFValue(j) * -1) {
                    graph.addEdge(i, j);
                }
            }
        }
    }

    private int getCNFValue(int graphIndex) {
        int termIdx = (graphIndex) % cnf.getNumVariables();
        int clauseIdx = 0;

        if (cnf.getNumVariables() < graphIndex) {
            clauseIdx = (int)(Math.ceil(graphIndex / cnf.getNumVariables()) - 1);
        }

        return cnf.getTerm(clauseIdx, termIdx);
    }

    private void connectClause(Graph graph) {
        for (int i = 0; i < graph.getNumVertex(); i+=cnf.getNumVariables()) {
            for (int j = 1; j < cnf.getNumVariables(); j++) {
                graph.addEdge(i + j, i + j);
            }
        }
    }

    private boolean isInSameTerm(int fromIndex, int toIndex) {
        return Math.floor(fromIndex/cnf.getNumVariables()) == Math.floor(toIndex/cnf.getNumVariables());
    }

    /***********GETTERS***********/
	public CNF getCNF() {
		return cnf;
    }
    
    public Graph getGraph() {
        return graph;
    }

    public int getK() {
        return k;
    }
}
