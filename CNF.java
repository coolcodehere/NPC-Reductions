public class CNF {
	private int numVariables;
	private int numClauses;
	private int[][] cnf;

	/***********CONSTRUCTORS***********/
	public CNF(int[][] cnf) {
		this.cnf = cnf;
		numVariables = cnf[0].length;
		numClauses = cnf.length;
	}

	/***********METHODS***********/
	public void printCNF() {
		for (int[] clause : cnf) {
			for (int literal : clause) {
				System.out.print(literal + " ");
			}
			System.out.println();
		}
	}

	/***********GETTERS***********/
	public int getNumVariables() {
		return numVariables;
	}

	public int getNumClauses() {
		return numClauses;
	}
	
	public int[][] getCNF() {
		return cnf;
	}

	public int[] getClause(int i) {
		return cnf[i];
	}

	public int getTerm(int clauseIndex, int termIndex) {
		return getClause(clauseIndex)[termIndex];
	}
}