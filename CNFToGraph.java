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
          for (int j = 0; j < graph.size; j++) {
              if (i != j && !isInSameTerm(i, j) && !isContradictiory(i, j)) {
                  graph.addEdge(i, j);
              }
          }
      }
    }

    private int getCNFValueFromGraphIndex(int graphIndex) {
        return cnf.cnfVals.get(graphIndex);
    }

    private boolean isInSameTerm(int fromIndex, int toIndex) {
        return Math.floor(fromIndex/cnf.numTerms) == Math.floor(toIndex/cnf.numTerms);
    }

    private boolean isContradictiory(int fromIndex, int toIndex) {
        return getCNFValueFromGraphIndex(fromIndex) * -1 == getCNFValueFromGraphIndex(toIndex);
    }
}
