import java.util.ArrayList;

public class solve3CNF {
    public static void main(String args[]) {
        String cnfFilename = "cnfs2020.txt";
        CNFParser cnf = new CNFParser(cnfFilename);
        ArrayList<CNF> cnfs = cnf.getCNFS();
    }
}
