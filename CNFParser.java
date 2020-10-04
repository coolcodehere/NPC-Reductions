import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.lang.Integer;

// This class exists to parse the input file and generate an arraylist of CNFs from it. 
class CNFParser {
	private ArrayList<CNF> cnfArray = new ArrayList<CNF>();
	private File cnfFile;

	public CNFParser(String cnfFileName) {
		this.cnfFile = new File(cnfFileName);
		readCNF();
	}

	private void readCNF() {
		Scanner scan = null;
		try {
			scan = new Scanner(cnfFile);
		} catch (Exception e) {

		}
		
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
		
			if (line.charAt(0) == '0') {
				return;
			}

			String[] nums = line.split(" ");
			CNF newCNF = new CNF(buildCNF(nums), Integer.parseInt(nums[0]));
			cnfArray.add(newCNF);
		}
		
	}

	private int[][] buildCNF(String[] data) {
		int termsPerClause = 3;

		int numClauses = (data.length - 1) / termsPerClause;
		int[][] cnf = new int[numClauses][termsPerClause];
		int numsIndex = 1;

		for (int i = 0; i < numClauses; i++) {
			for (int j = 0; j < termsPerClause; j++) {
				cnf[i][j] = Integer.parseInt(data[numsIndex++]);
			}
		}

		return cnf;
	}

	public ArrayList<CNF> getCNFS() {
		return cnfArray;
	}
}