import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static final String YELLOW_BOLD = "\033[1;33m";
    public static final String RESET = "\033[0m";
    private final static String FILE_NAME = "../resources/italian_dist_graph.csv";

    public static void graphFromFile(Graph<String, Float> graph) {
        try{
            FileReader fr = new FileReader(FILE_NAME);
            BufferedReader fileIn = new BufferedReader(fr);
            String line = fileIn.readLine();
            while(line != null){
                String[] token = line.split(",");
                graph.addVertex(token[0]);
                graph.addVertex(token[1]);
                graph.addArch(token[0], token[1], Float.parseFloat(token[2])/1000);
                line = fileIn.readLine();
            }
            fr.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Graph<String, Float> graph = new Graph<>(false);
        graphFromFile(graph);
        System.out.println(graph+"\n\n");
        String src = "torino";
        String dest = "catania";
        Dijkstra<String, Float> dijkstra = new Dijkstra<>(graph, src);
        System.out.println(YELLOW_BOLD + "Distance from " + src.substring(0, 1).toUpperCase() + src.substring(1) + " to " + dest.substring(0, 1).toUpperCase() + dest.substring(1) + " is: " + RESET + dijkstra.getDistance(dest));
        System.out.println(YELLOW_BOLD + "Path from " + src.substring(0, 1).toUpperCase() + src.substring(1) + " to " + dest.substring(0, 1).toUpperCase() + dest.substring(1) + " is: " + RESET + dijkstra.getPath(dest)+"\n\n\n");

    }
}
