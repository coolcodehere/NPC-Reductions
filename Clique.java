import java.util.ArrayList;

public class Clique {
    private ArrayList<Integer> vertices;
    private long ms;

    /***********CONSTRUCTORS***********/
    public Clique(ArrayList<Integer> vertices, long ms) {
        this.vertices = vertices;
        this.ms = ms;
    }

    /***********METHODS***********/
    public String toString() {
        String temp = "{";
        for (int vertex : vertices) {
            temp += vertex + ",";
        }
        temp += "\b} (size=" + vertices.size() + ", ms=" + ms + ")";
        return temp;
    }

    /***********GETTERS***********/
    public ArrayList<Integer> getVertices() {
        return vertices;
    }

    public long getMS() {
        return ms;
    }
}
