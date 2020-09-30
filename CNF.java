class CNF {
	int numTerms;
	int numClauses;
	int[][] cnf;

	public CNF(int[][] cnf) {
		this.cnf = cnf;
		numTerms = cnf[0].length;
		numClauses = cnf.length;
	}

	public int[] getClause(int i) {
		return cnf[i];
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