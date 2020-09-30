import java.util.ArrayList;

public class Clique {
    private ArrayList<String> vertices;
    private int ms;

    /***********CONSTRUCTORS***********/
    public Clique(ArrayList<String> vertices, int ms) {
        this.vertices = vertices;
        this.ms = ms;
    }

    /***********METHODS***********/
    public String toString() {
        String temp = "{";
        for (String vertex : vertices) {
            temp += vertex;
            if (!vertex.equals(vertices.get(vertices.size() - 1))) {
                temp += ",";
            }
        }
        temp += "} (size=" + vertices.size() + ", ms=" + ms + ")";
        return temp;
    }

    /***********GETTERS***********/
    public ArrayList<String> getVertices() {
        return vertices;
    }

    public int getMS() {
        return ms;
    }
}
