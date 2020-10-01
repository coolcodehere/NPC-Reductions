import java.util.Set;

public class Clique {
    private Set<String> vertices;
    private long ms;

    /***********CONSTRUCTORS***********/
    public Clique(Set<String> vertices, long ms) {
        this.vertices = vertices;
        this.ms = ms;
    }

    /***********METHODS***********/
    public String toString() {
        String temp = "{";
        for (String vertex : vertices) {
            temp += vertex + ",";
        }
        temp += "\b} (size=" + vertices.size() + ", ms=" + ms + ")";
        return temp;
    }

    /***********GETTERS***********/
    public Set<String> getVertices() {
        return vertices;
    }

    public long getMS() {
        return ms;
    }
}
