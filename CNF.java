import java.util.ArrayList;

class CNF {
	int numVars;
	int numTerms;
	int numClauses;
	int[][] cnf;
	ArrayList<Integer> cnfVals = new ArrayList<>();

	public CNF(int[][] cnf, int numVars) {
		this.cnf = cnf;
		numTerms = cnf[0].length;
		numClauses = cnf.length;
		this.numVars = numVars;
		for (int[] arr : cnf) {
			for (int num : arr) {
				cnfVals.add(num);
			}
		}
	}

	public int[] getClause(int i) {
		return cnf[i];
	}

	public int getTerm(int clauseIndex, int termIndex) {
		return getClause(clauseIndex)[termIndex];
	}

	public void printCNF() {
		for (int[] arr : cnf) {
			for (int term : arr) {
				System.out.print(term + " ");
			}
			System.out.println();
		}
	}

	public int[][] getCNF() {
		return cnf;
	}
}