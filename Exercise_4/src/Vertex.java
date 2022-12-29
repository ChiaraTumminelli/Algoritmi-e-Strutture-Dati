import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("rawtypes")
public class Vertex<A,B>{
    
    private A value;
    private List<Arch> edges;
    private boolean visited;
    private Vertex previousVertex;
    private B minDistance;

    // Constructor method
    public Vertex(A value){
        this.value = value;
        this.edges = new ArrayList<>();
    }

    // Time Complexity : O(1)
    public A getValue(){
        return this.value;
    }

    // Time Complexity : O(1)
    public void setValue(A value){ this.value = value; }

    // Time Complexity : O(1)
    public void addNeighbour(Arch edge) {
        this.edges.add(edge);
    }

    // Time Complexity : O(1)
    public List<Arch> getEdges() {
        return edges;
    }

    // Time Complexity : O(1)
    public void setEdges(List<Arch> edges) {
        this.edges = edges;
    }

    // Time Complexity : O(1)
    public boolean isVisited() {
        return visited;
    }

    // Time Complexity : O(1)
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    // Time Complexity : O(1)
    public Vertex getPreviousVertex() {
        return previousVertex;
    }

    // Time Complexity : O(1)
    public void setPreviousVertex(Vertex previousVertex) {
        this.previousVertex = previousVertex;
    }

    // Time Complexity : O(1)
    public B getMinDistance() {
        return minDistance;
    }

    // Time Complexity : O(1)
    public void setMinDistance(B minDistance) {
        this.minDistance = minDistance;
    }

}