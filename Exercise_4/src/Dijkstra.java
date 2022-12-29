import static java.math.BigDecimal.valueOf;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

@SuppressWarnings("unchecked")
public class Dijkstra<V, B extends Number & Comparable<B>> {

    private V source;
    private HashMap<V, B> distances;
    private HashMap<V, V> predecessors;
    private PriorityQueue<Arch<V, B>> queue;

    // Time Complexity : O(n log n)
    public Dijkstra(Graph<V, B> graph, V source) {
      
        this.source = source;
        this.distances = new HashMap<>();
        this.predecessors = new HashMap<>();
        this.queue = new PriorityQueue<>();

        for (V vertex : graph.getListOfVertex()) {
            distances.put(vertex, (B) Float.valueOf(Float.MAX_VALUE));
            predecessors.put(vertex, null);
        }

        distances.put(source, (B) Float.valueOf(0.0F));
        queue.add(new Arch<>(source, source, (B) Float.valueOf(0.0F)));

        while (!queue.isEmpty()) {
            V u = queue.poll().getDest();
            for (V v : graph.getAdjacentList(u)) {
                B newDistance = (B) BigDecimal.valueOf(distances.get(u).floatValue()).add(valueOf(((Number) graph.getWeight(u, v)).floatValue()));
                if (newDistance.compareTo((B) BigDecimal.valueOf(distances.get(v).floatValue())) < 0){
                    distances.put(v, newDistance);
                    predecessors.put(v, u);
                    queue.add(new Arch<>(v, v, newDistance));
                }
            }
        }
    }

    // Time Complexity : O(1)
    public B getDistance(V destination) {
        return distances.get(destination);
    }

    // Time Complexity : O(n)
    public ArrayList<V> getPath(V destination) {
        ArrayList<V> path = new ArrayList<>();
        V current = destination;
        while (current != source) {
            path.add(current);
            current = predecessors.get(current);
        }
        path.add(source);
        Collections.reverse(path);
        return path;
    }

}
