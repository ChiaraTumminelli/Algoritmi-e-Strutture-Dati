import java.util.ArrayList;
import java.util.Hashtable;

public class Graph<V, B extends Comparable<B>> {
    private boolean oriented;
    private Hashtable<V, Hashtable<V, B>> graph;

    public Graph(boolean oriented){
        this.oriented = oriented;
        this.graph = new Hashtable<>();
    }

    // Addition of a vertex - Time Complexity : O(1)
    public void addVertex(V vertex){
        graph.putIfAbsent(vertex, new Hashtable<>());
    }

    // Addition af an arch - Time Complexity : O(1)
    public void addArch(V src, V dest, B weight){
        if(graph.containsKey(src))
            graph.get(src).put(dest, weight);
        if(!oriented && graph.containsKey(dest))
            graph.get(dest).put(src, weight);
    }

    // Check if graph is oriented or not - Time Complexity : O(1)
    public boolean isOriented() {
        return oriented;
    }

    // Check if graph contains a given vertex - Time Complexity : O(1)
    public boolean hasVertex(V vertex){
        return graph.containsKey(vertex);
    }

    // Check if graph contains a given arch - Time Complexity : O(1)
    public boolean hasArch(V src, V dest){
        if(graph.containsKey(src))
            return graph.get(src).containsKey(dest);
        return false;
    }

    // Removal of a vertex - Time Complexity : O(n)
    public void deleteVertex(V vertex){
        graph.remove(vertex);
        for (V v : graph.keySet()) {
            graph.get(v).remove(vertex);
        }
    }

    // Removal of an arch - Time Complexity : O(1)
    public void deleteArch(V src, V dest){
        graph.get(src).remove(dest);
        if(!oriented)
            graph.get(dest).remove(src);
    }

    // Determination of the number of vertices - Time Complexity : O(1)
    public int getVertexNum(){
       return graph.size();
    }

    // Determination of the number of arc - Time Complexity : O(n)
    public int getArchNum(){
        int count = 0;
        for (V t : graph.keySet()) {
            count = count + graph.get(t).size();
        }
        if(!oriented)
            return count/2;
        return count;
    }

    // Recovery of the vertex of the graph - Time Complexity : O(n)
    public ArrayList<V> getListOfVertex(){
        return new ArrayList<V>(graph.keySet());
    }

    // Recovery of the arches of the graph - Time Complexity : O(n)
    public ArrayList<Arch<V, B>> getListOfArch(){
        ArrayList<Arch<V, B>> edges = new ArrayList<Arch<V, B>>();
        for (V v1 : graph.keySet()) {
            for (V v2 : graph.get(v1).keySet()) {
                edges.add(new Arch<>(v1, v2, graph.get(v1).get(v2)));
            }
        }
        return edges;
    }

    // Recovery of adjacent vertexes of the graph - Time Complexity : O(1)
    public ArrayList<V> getAdjacentList(V srcVertex){
        if(graph.containsKey(srcVertex))
            return new ArrayList<>(graph.get(srcVertex).keySet());
        return new ArrayList<>();
    }

    // Recovery of arch weight - Time Complexity : O(1)
    public B getWeight(V src, V dest) {
        if (graph.containsKey(src) && graph.get(src).containsKey(dest)) {
            return graph.get(src).get(dest);
        }
        return null;
    }

    @Override
    public String toString(){
        return "Graph = { " + graph + " }";
    }

}

