import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class GraphTest {

    @Test
    public void testAddVertexOrientedGraph() {
        Graph<String, Integer> graph = new Graph<>(true);
        graph.addVertex("A");
        assertTrue(graph.hasVertex("A"));
        assertEquals(1, graph.getVertexNum());
    }

    @Test
    public void testAddVertexNotOrientedGraph() {
        Graph<String, Integer> graph = new Graph<>(false);
        graph.addVertex("A");
        assertTrue(graph.hasVertex("A"));
        assertFalse(graph.hasVertex("B"));
    }

    @Test
    public void testAddArchOrientedGraph() {
        Graph<String, Integer> graph = new Graph<>(true);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addArch("A", "B", 2);
        assertTrue(graph.hasArch("A", "B"));
        assertEquals(2, (int) graph.getWeight("A", "B"));
        assertEquals(1, graph.getArchNum());
    }

    @Test
    public void testAddArchNotOrientedGraph() {
        Graph<String, Integer> graph = new Graph<>(false);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addArch("A", "B", 5);
        assertTrue(graph.hasArch("A", "B"));
        assertTrue(graph.hasArch("B", "A"));
        assertFalse(graph.hasArch("A", "C"));
    }

    @Test
    public void testIsOrientedGraph() {
        Graph<String, Integer> NotorientedGraph = new Graph<>(true);
        Graph<String, Integer> nonNotOrientedGraph = new Graph<>(false);
        assertTrue(NotorientedGraph.isOriented());
        assertFalse(nonNotOrientedGraph.isOriented());
    }

    @Test
    public void testHasVertexOrientedGraph() {
        Graph<String, Integer> graph = new Graph<>(true);
        graph.addVertex("A");
        graph.addVertex("B");
        assertTrue(graph.hasVertex("A"));
        assertTrue(graph.hasVertex("B"));
        assertFalse(graph.hasVertex("C"));
    }

    @Test
    public void testHasVertexNotOrientedGraph() {
        Graph<String, Integer> graph = new Graph<>(false);
        graph.addVertex("A");
        assertTrue(graph.hasVertex("A"));
        assertFalse(graph.hasVertex("B"));
    }

    @Test
    public void testHasArchOrientedGraph() {
        Graph<String, Integer> graph = new Graph<>(true);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addArch("A", "B", 1);
        graph.addArch("A", "C", 2);
        graph.addArch("B", "C", 3);
        graph.addArch("B", "D", 4);
        graph.addArch("C", "D", 5);
        assertTrue(graph.hasArch("A", "B"));
        assertTrue(graph.hasArch("A", "C"));
        assertTrue(graph.hasArch("B", "C"));
        assertTrue(graph.hasArch("B", "D"));
        assertTrue(graph.hasArch("C", "D"));
        assertFalse(graph.hasArch("A", "D"));
        assertFalse(graph.hasArch("D", "A"));
    }

    @Test
    public void testHasArchNotOrientedGraph() {
        Graph<String, Integer> graph = new Graph<>(false);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addArch("A", "B", 5);
        assertTrue(graph.hasArch("A", "B"));
        assertTrue(graph.hasArch("B", "A"));
        assertFalse(graph.hasArch("A", "C"));
    }

    @Test
    public void testDeleteVertexOrientedGraph() {
        Graph<String, Integer> graph = new Graph<>(true);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addArch("A", "B", 1);
        graph.addArch("A", "C", 2);
        graph.addArch("B", "C", 3);
        graph.addArch("B", "D", 4);
        graph.addArch("C", "D", 5);
        graph.deleteVertex("B");
        assertFalse(graph.hasVertex("B"));
        assertFalse(graph.hasArch("A", "B"));
        assertFalse(graph.hasArch("B", "C"));
        assertFalse(graph.hasArch("B", "D"));
        assertEquals(3, graph.getVertexNum());
        assertEquals(2, graph.getArchNum());
    }

    @Test
    public void testDeleteVertexNotOrientedGraph() {
        Graph<String, Integer> graph = new Graph<>(false);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addArch("A", "B", 5);
        graph.addArch("B", "C", 8);
        graph.deleteVertex("B");
        assertFalse(graph.hasVertex("B"));
        assertFalse(graph.hasArch("A", "B"));
        assertFalse(graph.hasArch("B", "C"));
        assertEquals(2, graph.getVertexNum());
    }

    @Test
    public void testDeleteArchOrientedGraph() {
        Graph<String, Integer> graph = new Graph<>(true);

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addArch("A", "B", 1);
        graph.addArch("A", "C", 2);
        graph.addArch("B", "C", 3);
        graph.addArch("B", "D", 4);
        graph.addArch("C", "D", 5);

        graph.deleteArch("A", "B");

        assertFalse(graph.hasArch("A", "B"));
        assertEquals(4, graph.getVertexNum());
        assertEquals(4, graph.getArchNum());
    }

    @Test
    public void testDeleteArchNotOrientedGraph() {
        Graph<String, Integer> graph = new Graph<>(false);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addArch("A", "B", 5);
        graph.addArch("B", "C", 8);
        graph.deleteArch("A", "B");
        assertFalse(graph.hasArch("A", "B"));
        assertFalse(graph.hasArch("B", "A"));
        assertTrue(graph.hasArch("B", "C"));
        assertEquals(3, graph.getVertexNum());
        assertEquals(1, graph.getArchNum());
    }

    @Test
    public void testGetVertexNumOrientedGraph() {
        Graph<String, Integer> graph = new Graph<>(true);
        assertEquals(0, graph.getVertexNum());
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        assertEquals(4, graph.getVertexNum());
        graph.deleteVertex("B");
        assertEquals(3, graph.getVertexNum());
    }

    @Test
    public void testGetVertexNumNotOrientedGraph() {
        Graph<String, Integer> graph = new Graph<>(false);
        assertEquals(0, graph.getVertexNum());
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        assertEquals(3, graph.getVertexNum());
        graph.deleteVertex("B");
        assertEquals(2, graph.getVertexNum());
    }

    @Test
    public void testGetArchNumOrientedGraph() {
        Graph<String, Integer> graph = new Graph<>(true);
        assertEquals(0, graph.getArchNum());
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addArch("A", "B", 1);
        graph.addArch("A", "C", 2);
        graph.addArch("B", "C", 3);
        graph.addArch("B", "D", 4);
        graph.addArch("C", "D", 5);
        assertEquals(5, graph.getArchNum());
        graph.deleteArch("A", "B");
        assertEquals(4, graph.getArchNum());
    }

    @Test
    public void testGetArchNumNotOrientedGraph() {
        Graph<String, Integer> graph = new Graph<>(false);
        assertEquals(0, graph.getArchNum());
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addArch("A", "B", 5);
        graph.addArch("B", "C", 8);
        graph.addArch("C", "A", 2);
        assertEquals(3, graph.getArchNum());
        graph.deleteArch("A", "B");
        assertEquals(2, graph.getArchNum());
    }

    @Test
    public void testGetListOfVertexOrientedGraph() {
        Graph<String, Integer> graph = new Graph<>(true);
        assertEquals(new ArrayList<>(), graph.getListOfVertex());
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        assertTrue(new ArrayList<String>(Arrays.asList("A", "B", "C", "D")).containsAll(graph.getListOfVertex())
                && graph.getListOfVertex().containsAll(new ArrayList<String>(Arrays.asList("A", "B", "C", "D"))));
        graph.deleteVertex("B");
        assertTrue(new ArrayList<String>(Arrays.asList("A", "C", "D")).containsAll(graph.getListOfVertex())
                && graph.getListOfVertex().containsAll(new ArrayList<String>(Arrays.asList("A", "C", "D"))));
    }

    @Test
    public void testGetListOfVertexNotOrientedGraph() {
        Graph<String, Integer> graph = new Graph<>(false);
        assertEquals(new ArrayList<String>(), graph.getListOfVertex());
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        List<String> expected = Arrays.asList("A", "B", "C");
        assertTrue(graph.getListOfVertex().containsAll(expected) && expected.containsAll(graph.getListOfVertex()));
        graph.deleteVertex("B");
        assertEquals(new ArrayList<String>(Arrays.asList("A", "C")), graph.getListOfVertex());
    }

    @Test
    public void testGetAdjacentListOrientedGraph() {
        Graph<String, Integer> graph = new Graph<>(true);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addArch("A", "B", 1);
        graph.addArch("A", "C", 2);
        graph.addArch("B", "C", 3);
        graph.addArch("B", "D", 4);
        graph.addArch("C", "D", 5);
        assertTrue(new ArrayList<String>(Arrays.asList("B", "C")).containsAll(graph.getAdjacentList("A"))
                && graph.getAdjacentList("A").containsAll(new ArrayList<String>(Arrays.asList("B", "C"))));
        assertTrue(new ArrayList<String>(Arrays.asList("C", "D")).containsAll(graph.getAdjacentList("B"))
                && graph.getAdjacentList("A").containsAll(new ArrayList<String>(Arrays.asList("B", "C"))));
        assertEquals(new ArrayList<String>(Arrays.asList("D")), graph.getAdjacentList("C"));
        assertEquals(new ArrayList<>(), graph.getAdjacentList("D"));
        assertEquals(new ArrayList<>(), graph.getAdjacentList("E"));
    }

    @Test
    public void testGetAdjacentListNotOrientedGraph() {
        Graph<String, Integer> graph = new Graph<>(false);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addArch("A", "B", 5);
        graph.addArch("B", "C", 8);
        graph.addArch("C", "A", 2);
        graph.addArch("A", "D", 7);
        List<String> expected = Arrays.asList("B", "D", "C");
        assertTrue(
                graph.getAdjacentList("A").containsAll(expected) && expected.containsAll(graph.getAdjacentList("A")));
        assertEquals(new ArrayList<String>(Arrays.asList("A", "C")), graph.getAdjacentList("B"));
        assertEquals(new ArrayList<String>(Arrays.asList("A", "B")), graph.getAdjacentList("C"));
        assertEquals(new ArrayList<String>(Arrays.asList("A")), graph.getAdjacentList("D"));
        assertEquals(new ArrayList<String>(), graph.getAdjacentList("E"));
    }

    @Test
    public void testGetWeightOrientedGraph() {
        Graph<String, Integer> graph = new Graph<>(true);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addArch("A", "B", 1);
        graph.addArch("A", "C", 2);
        graph.addArch("B", "C", 3);
        graph.addArch("B", "D", 4);
        graph.addArch("C", "D", 5);
        assertEquals(1, (int) graph.getWeight("A", "B"));
        assertEquals(2, (int) graph.getWeight("A", "C"));
        assertEquals(3, (int) graph.getWeight("B", "C"));
        assertEquals(4, (int) graph.getWeight("B", "D"));
        assertEquals(5, (int) graph.getWeight("C", "D"));
        assertNull(graph.getWeight("A", "D"));
        assertNull(graph.getWeight("A", "E"));
    }

    @Test
    public void testGetWeightNotOrientedGraph() {
        Graph<String, Integer> graph = new Graph<>(false);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addArch("A", "B", 5);
        graph.addArch("B", "C", 8);
        graph.addArch("C", "A", 2);
        assertEquals(5, (int) graph.getWeight("A", "B"));
        assertEquals(8, (int) graph.getWeight("B", "C"));
        assertEquals(2, (int) graph.getWeight("C", "A"));
        assertTrue(graph.getWeight("A", "C") == 2);
        assertNull(graph.getWeight("D", "A"));
        assertNull(graph.getWeight("A", "D"));
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(GraphTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println("\nJUNIT TEST RESULTS : " + result.wasSuccessful() + "\n");
    }
}
