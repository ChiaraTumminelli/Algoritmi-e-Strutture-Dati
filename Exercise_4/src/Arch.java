public class Arch<V, B extends Comparable<B>> implements Comparable<Arch<V, B>>{
    
    private V src;
    private V dest;
    private B weight;

    // Constructor method
    public Arch(V src, V dest, B cost){
        this.weight = cost;
        this.dest = dest;
        this.src = src;
    }

    // Time Complexity : O(1)
    public void setWeight(B weight) {
        this.weight = weight;
    }

    // Time Complexity : O(1)
    public void setDest(V dest) {
        this.dest = dest;
    }

    // Time Complexity : O(1)
    public void setSrc(V src) {
        this.src = src;
    }

    // Time Complexity : O(1)
    public B getWeight() {
        return weight;
    }

    // Time Complexity : O(1)
    public V getDest() {
        return dest;
    }

    // Time Complexity : O(1)
    public V getSrc() {
        return src;
    }

    @Override
    public int compareTo(Arch<V, B> e){
        return this.weight.compareTo(e.getWeight());
    }
}
