public class CNFToGraph {
    private CNF cnf;

    public CNFToGraph(CNF cnf) {
        this.cnf = cnf;
    }

    public Graph convertClique() {
        Graph graph = new Graph(cnf.numTerms * cnf.numClauses);

        connectTerms(graph);
        return graph;
    }

    private void connectTerms(Graph graph) {
        for (int i = 0; i < graph.size; i++) {
            int termValue = getCNFValue(i);
            for (int j = 0; j < graph.size; j++) {
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
        int termIdx = (graphIndex) % cnf.numTerms;
        int clauseIdx = 0;

        if (cnf.numTerms < graphIndex) {
            clauseIdx = (int)(Math.ceil(graphIndex / cnf.numTerms) - 1);
        }

        return cnf.getTerm(clauseIdx, termIdx);
    }

    private void connectClause(Graph graph) {
        for (int i = 0; i < graph.size; i+=cnf.numTerms) {
            for (int j = 1; j < cnf.numTerms; j++) {
                graph.addEdge(i + j, i + j);
            }
        }
    }

    private boolean isInSameTerm(int fromIndex, int toIndex) {
        return Math.floor(fromIndex/cnf.numTerms) == Math.floor(toIndex/cnf.numTerms);
    }
}
