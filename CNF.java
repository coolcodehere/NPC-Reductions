import java.util.ArrayList;

class CNF {
	private int numVariables;
	private int numTerms;
	private int numClauses;
	private int[][] cnf;
	private ArrayList<Integer> cnfVals = new ArrayList<>();

	/***********CONSTRUCTORS***********/
	public CNF(int[][] cnf, int numV) {
		this.cnf = cnf;
		numVariables = cnf[0].length;
		numClauses = cnf.length;
		numVariables = numV;
		for (int[] arr : cnf) {
			for (int num : arr) {
				cnfVals.add(num);
			}
		}
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

	public int getNumTerms() {
		return numTerms;
	}

	public int getNumClauses() {
		return numClauses;
	}
	
	public int[][] getCNF() {
		return cnf;
	}

	public ArrayList<Integer> getCNFVals() {
		return cnfVals;
	}

	public int[] getClause(int i) {
		return cnf[i];
	}

	public int getTerm(int clauseIndex, int termIndex) {
		return getClause(clauseIndex)[termIndex];
	}
}