public class CNFToGraph {
    private CNF cnf;
    private Graph graph;

    /***********CONSTRUCTORS***********/
    public CNFToGraph(CNF c) {
        cnf = c;
        graph = convertClique();
    }

    /***********PUBLIC METHODS***********/
    public String toString() {
        return "[n=" + cnf.getNumVariables() + " k=" + cnf.getNumClauses() + "]";
    }

    /***********PRIVATE METHODS***********/
    private Graph convertClique() {
        Graph graph = new Graph(cnf.getNumVariables() * cnf.getNumClauses());

        connectTerms(graph);
        return graph;
    }

    private void connectTerms(Graph graph) {
      for (int i = 0; i < graph.getNumVertex(); i++) {
          for (int j = 0; j < graph.getNumVertex(); j++) {
              if (i != j && !isInSameTerm(i, j) && !isContradictiory(i, j)) {
                  graph.addEdge(i, j);
              }
          }
      }
    }

    private int getCNFValueFromGraphIndex(int graphIndex) {
        return cnf.getCNFVals().get(graphIndex);
    }

    private boolean isInSameTerm(int fromIndex, int toIndex) {
        return Math.floor(fromIndex/cnf.getNumTerms()) == Math.floor(toIndex/cnf.getNumTerms());
    }

    private boolean isContradictiory(int fromIndex, int toIndex) {
        return getCNFValueFromGraphIndex(fromIndex) * -1 == getCNFValueFromGraphIndex(toIndex);
    }

    /***********GETTERS***********/
	public CNF getCNF() {
		return cnf;
    }
    
    public Graph getGraph() {
        return graph;
    }
}
