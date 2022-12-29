import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeapMinTest {

    private final HeapMin<Integer> heapI = new HeapMin<>();
    private final HeapMin<Double> heapD = new HeapMin<>();
    private final HeapMin<String> heapS = new HeapMin<>();

    @Test
    public void getSizeTestEmptyInt() {
        assertEquals(0, heapI.getSize());
    }

    @Test
    public void getSizeTestEmptyDouble() {
        assertEquals(0, heapD.getSize());
    }

    @Test
    public void getSizeTestEmptyString() {
        assertEquals(0, heapS.getSize());
    }

    @Test
    public void getSizeTestFilledInt() {
        heapI.insertElem(10);
        heapI.insertElem(9);
        heapI.insertElem(1);
        heapI.insertElem(3);
        heapI.insertElem(12);
        assertEquals(5, heapI.getSize());
    }

    @Test
    public void getSizeTestFilledDouble() {
        heapD.insertElem(4.5);
        heapD.insertElem(8.0);
        heapD.insertElem(1.6);
        heapD.insertElem(3.7);
        heapD.insertElem(12.2);
        assertEquals(5, heapD.getSize());
    }

    @Test
    public void getSizeTestFilledString() {
        heapS.insertElem("Sara");
        heapS.insertElem("Chiara");
        heapS.insertElem("Carmine");
        heapS.insertElem("Samuele");
        heapS.insertElem("Antonio");
        assertEquals(5, heapS.getSize());
    }

    @Test
    public void hasParentTestInt() {
        heapI.insertElem(10);
        heapI.insertElem(9);
        heapI.insertElem(1);
        heapI.insertElem(3);
        heapI.insertElem(12);
        assertTrue(heapI.hasParent(1));
    }

    @Test
    public void hasParentTestDouble() {
        heapD.insertElem(4.5);
        heapD.insertElem(8.0);
        heapD.insertElem(1.6);
        heapD.insertElem(3.7);
        heapD.insertElem(12.2);
        assertTrue(heapD.hasParent(1));
    }

    @Test
    public void hasParentTestString() {
        heapS.insertElem("Sara");
        heapS.insertElem("Chiara");
        heapS.insertElem("Carmine");
        heapS.insertElem("Samuele");
        heapS.insertElem("Antonio");
        assertTrue(heapS.hasParent(1));
    }

    @Test
    public void hasleftChildTestInt() {
        heapI.insertElem(10);
        heapI.insertElem(9);
        heapI.insertElem(1);
        heapI.insertElem(3);
        heapI.insertElem(12);
        assertTrue(heapI.hasLeftChild(0));
    }

    @Test
    public void hasLeftChildTestDouble() {
        heapD.insertElem(4.5);
        heapD.insertElem(8.0);
        heapD.insertElem(1.6);
        heapD.insertElem(3.7);
        heapD.insertElem(12.2);
        assertTrue(heapD.hasLeftChild(0));
    }

    @Test
    public void hasLeftChildTestString() {
        heapS.insertElem("Sara");
        heapS.insertElem("Chiara");
        heapS.insertElem("Carmine");
        heapS.insertElem("Samuele");
        heapS.insertElem("Antonio");
        assertTrue(heapS.hasLeftChild(0));
    }

    @Test
    public void hasRightChildTestInt() {
        heapI.insertElem(10);
        heapI.insertElem(9);
        heapI.insertElem(1);
        heapI.insertElem(3);
        heapI.insertElem(12);
        assertTrue(heapI.hasRightChild(0));
    }

    @Test
    public void hasRightChildTestDouble() {
        heapD.insertElem(4.5);
        heapD.insertElem(8.0);
        heapD.insertElem(1.6);
        heapD.insertElem(3.7);
        heapD.insertElem(12.2);
        assertTrue(heapD.hasRightChild(0));
    }

    @Test
    public void hasRightChildTestString() {
        heapS.insertElem("Sara");
        heapS.insertElem("Chiara");
        heapS.insertElem("Carmine");
        heapS.insertElem("Samuele");
        heapS.insertElem("Antonio");
        assertTrue(heapS.hasRightChild(0));
    }

    @Test
    public void getParentIndexTestInt() {
        heapI.insertElem(10);
        heapI.insertElem(9);
        heapI.insertElem(1);
        heapI.insertElem(3);
        heapI.insertElem(12);
        assertEquals(0, heapI.getParentIndex(1));
    }

    @Test
    public void getParentIndexTestDouble() {
        heapD.insertElem(4.5);
        heapD.insertElem(8.0);
        heapD.insertElem(1.6);
        heapD.insertElem(3.7);
        heapD.insertElem(12.2);
        assertEquals(0, heapD.getParentIndex(1));
    }

    @Test
    public void getParentIndexTestString() {
        heapS.insertElem("Sara");
        heapS.insertElem("Chiara");
        heapS.insertElem("Carmine");
        heapS.insertElem("Samuele");
        heapS.insertElem("Antonio");
        assertEquals(0, heapD.getParentIndex(1));
    }

    @Test
    public void getLeftChildIndexTestInt() {
        heapI.insertElem(10);
        heapI.insertElem(9);
        heapI.insertElem(1);
        heapI.insertElem(3);
        heapI.insertElem(12);
        assertEquals(1, heapI.getLeftChildIndex(0));
    }

    @Test
    public void getLeftChildIndexTestDouble() {
        heapD.insertElem(4.5);
        heapD.insertElem(8.0);
        heapD.insertElem(1.6);
        heapD.insertElem(3.7);
        heapD.insertElem(12.2);
        assertEquals(1, heapD.getLeftChildIndex(0));
    }

    @Test
    public void getLeftChildIndexTestString() {
        heapS.insertElem("Sara");
        heapS.insertElem("Chiara");
        heapS.insertElem("Carmine");
        heapS.insertElem("Samuele");
        heapS.insertElem("Antonio");
        assertEquals(1, heapD.getLeftChildIndex(0));
    }

    @Test
    public void getRightChildIndexTestInt() {
        heapI.insertElem(10);
        heapI.insertElem(9);
        heapI.insertElem(1);
        heapI.insertElem(3);
        heapI.insertElem(12);
        assertEquals(2, heapI.getRightChildIndex(0));
    }

    @Test
    public void getRightChildIndexTestDouble() {
        heapD.insertElem(4.5);
        heapD.insertElem(8.0);
        heapD.insertElem(1.6);
        heapD.insertElem(3.7);
        heapD.insertElem(12.2);
        assertEquals(2, heapD.getRightChildIndex(0));
    }

    @Test
    public void getRightChildIndexTestString() {
        heapS.insertElem("Sara");
        heapS.insertElem("Chiara");
        heapS.insertElem("Carmine");
        heapS.insertElem("Samuele");
        heapS.insertElem("Antonio");
        assertEquals(2, heapD.getRightChildIndex(0));
    }

    @Test
    public void parentTestInt() {
        heapI.insertElem(10);
        heapI.insertElem(9);
        heapI.insertElem(1);
        heapI.insertElem(3);
        heapI.insertElem(12);
        assertEquals(3, (int) heapI.parent(3));
    }

    @Test
    public void parentTestDouble() {
        heapD.insertElem(4.5);
        heapD.insertElem(8.0);
        heapD.insertElem(1.6);
        heapD.insertElem(3.7);
        heapD.insertElem(12.2);
        assertEquals(3.7, heapD.parent(3), 0.0);
    }

    @Test
    public void parentTestString() {
        heapS.insertElem("Sara");
        heapS.insertElem("Chiara");
        heapS.insertElem("Carmine");
        heapS.insertElem("Samuele");
        heapS.insertElem("Antonino");
        assertSame("Antonino", heapS.parent(1));
    }

    @Test
    public void leftChildTestInt() {
        heapI.insertElem(10);
        heapI.insertElem(9);
        heapI.insertElem(1);
        heapI.insertElem(3);
        heapI.insertElem(12);
        assertEquals(10, (int) heapI.leftChild(1));
    }

    @Test
    public void leftChildTestDouble() {
        heapD.insertElem(4.5);
        heapD.insertElem(8.0);
        heapD.insertElem(1.6);
        heapD.insertElem(3.7);
        heapD.insertElem(12.2);
        assertEquals(8.0, heapD.leftChild(1), 0.0);
    }

    @Test
    public void leftChildTestString() {
        heapS.insertElem("Sara");
        heapS.insertElem("Chiara");
        heapS.insertElem("Carmine");
        heapS.insertElem("Samuele");
        heapS.insertElem("Antonino");
        assertSame("Sara", heapS.leftChild(1));
    }

    @Test
    public void getRootTestInt() {
        heapI.insertElem(10);
        heapI.insertElem(9);
        heapI.insertElem(1);
        heapI.insertElem(3);
        heapI.insertElem(12);
        assertEquals(1, (int) heapI.getRoot());
    }

    @Test
    public void getRootTestDouble() {
        heapD.insertElem(4.5);
        heapD.insertElem(8.0);
        heapD.insertElem(1.6);
        heapD.insertElem(3.7);
        heapD.insertElem(12.2);
        assertEquals(1.6, heapD.getRoot(), 0.0);
    }

    @Test
    public void getRootTestString() {
        heapS.insertElem("Sara");
        heapS.insertElem("Chiara");
        heapS.insertElem("Carmine");
        heapS.insertElem("Samuele");
        heapS.insertElem("Antonino");
        assertSame("Antonino", heapS.getRoot());
    }

    @Test
    public void isEmptyTestEmptyInt() {
        assertTrue(heapI.isEmpty());
    }

    @Test
    public void isEmptyTestEmptyDouble() {
        assertTrue(heapD.isEmpty());
    }

    @Test
    public void isEmptyTestEmptyString() {
        assertTrue(heapS.isEmpty());
    }

    @Test
    public void isEmptyTestFilledInt() {
        heapI.insertElem(10);
        heapI.insertElem(9);
        heapI.insertElem(1);
        heapI.insertElem(3);
        heapI.insertElem(12);
        assertFalse(heapI.isEmpty());
    }

    @Test
    public void isEmptyTestFilledDouble() {
        heapD.insertElem(4.5);
        heapD.insertElem(8.0);
        heapD.insertElem(1.6);
        heapD.insertElem(3.7);
        heapD.insertElem(12.2);
        assertFalse(heapD.isEmpty());
    }

    @Test
    public void isEmptyTestFilledString() {
        heapS.insertElem("Sara");
        heapS.insertElem("Chiara");
        heapS.insertElem("Carmine");
        heapS.insertElem("Samuele");
        heapS.insertElem("Antonino");
        assertFalse(heapS.isEmpty());
    }

    @Test
    public void cleanTestInt() {
        heapI.insertElem(10);
        heapI.insertElem(9);
        heapI.insertElem(1);
        heapI.insertElem(3);
        heapI.insertElem(12);
        heapI.clean();
        assertEquals(0, heapI.getSize());
    }

    @Test
    public void cleanTestDouble() {
        heapD.insertElem(4.5);
        heapD.insertElem(8.0);
        heapD.insertElem(1.6);
        heapD.insertElem(3.7);
        heapD.insertElem(12.2);
        heapD.clean();
        assertEquals(0, heapD.getSize());
    }

    @Test
    public void cleanTestString() {
        heapS.insertElem("Sara");
        heapS.insertElem("Chiara");
        heapS.insertElem("Carmine");
        heapS.insertElem("Samuele");
        heapS.insertElem("Antonino");
        heapS.clean();
        assertEquals(0, heapS.getSize());
    }

    @Test
    public void getIndexTestInt() {
        heapI.insertElem(10);
        heapI.insertElem(9);
        heapI.insertElem(1);
        heapI.insertElem(3);
        heapI.insertElem(12);
        assertEquals(1, heapI.getIndex(3));
    }

    @Test
    public void getIndexTestDouble() {
        heapD.insertElem(4.5);
        heapD.insertElem(8.0);
        heapD.insertElem(1.6);
        heapD.insertElem(3.7);
        heapD.insertElem(12.2);
        assertEquals(1, heapD.getIndex(3.7));
    }

    @Test
    public void getIndexTestString() {
        heapS.insertElem("Sara");
        heapS.insertElem("Chiara");
        heapS.insertElem("Carmine");
        heapS.insertElem("Samuele");
        heapS.insertElem("Antonino");
        assertEquals(1, heapS.getIndex("Carmine"));
    }

    @Test
    public void insertElemTestInt() {
        heapI.insertElem(10);
        assertEquals(10, (int) heapI.getRoot());
    }

    @Test
    public void insertElemTestDouble() {
        heapD.insertElem(8.4);
        assertEquals(8.4, heapD.getRoot(), 0.0);
    }

    @Test
    public void insertElemTestString() {
        heapS.insertElem("Rossella");
        assertSame("Rossella", heapS.getRoot());
    }

    @Test
    public void deleteElementTestInt() {
        heapI.insertElem(10);
        heapI.insertElem(9);
        heapI.insertElem(1);
        heapI.insertElem(3);
        heapI.insertElem(12);
        heapI.deleteElem(1);
        assertTrue(heapI.getRoot() != 1);
    }

    @Test
    public void deleteElementTestDouble() {
        heapD.insertElem(4.5);
        heapD.insertElem(8.0);
        heapD.insertElem(1.6);
        heapD.insertElem(3.7);
        heapD.insertElem(12.2);
        heapD.deleteElem(1.6);
        assertTrue(heapD.getRoot() != 1.6);
    }

    @Test
    public void deleteElementTestString() {
        heapS.insertElem("Sara");
        heapS.insertElem("Chiara");
        heapS.insertElem("Carmine");
        heapS.insertElem("Samuele");
        heapS.insertElem("Antonino");
        heapS.deleteElem("Antonino");
        assertNotSame("Antonino", heapS.getRoot());
    }

    @Test
    public void extractMinTestInt() {
        heapI.insertElem(10);
        heapI.insertElem(9);
        heapI.insertElem(1);
        heapI.insertElem(3);
        heapI.insertElem(12);
        heapI.extractMin();
        assertEquals(3, (int) heapI.getRoot());
    }

    @Test
    public void extractMinTestDouble() {
        heapD.insertElem(4.5);
        heapD.insertElem(8.0);
        heapD.insertElem(1.6);
        heapD.insertElem(3.7);
        heapD.insertElem(12.2);
        heapD.extractMin();
        assertEquals(3.7, heapD.getRoot(), 0.0);
    }

    @Test
    public void extractMinTestString() {
        heapS.insertElem("Sara");
        heapS.insertElem("Chiara");
        heapS.insertElem("Carmine");
        heapS.insertElem("Samuele");
        heapS.insertElem("Antonino");
        heapS.extractMin();
        assertSame("Carmine", heapS.getRoot());
    }

    @Test
    public void replaceElemTestInt() {
        heapI.insertElem(10);
        heapI.insertElem(9);
        heapI.insertElem(1);
        heapI.insertElem(3);
        heapI.insertElem(12);
        heapI.replaceElem(1, 2);
        assertEquals(2, (int) heapI.getRoot());

    }

    @Test
    public void replaceElemTestDouble() {
        heapD.insertElem(4.5);
        heapD.insertElem(8.0);
        heapD.insertElem(1.6);
        heapD.insertElem(3.7);
        heapD.insertElem(12.2);
        heapD.replaceElem(1.6, 2.1);
        assertEquals(2.1, heapD.getRoot(), 0.0);
    }

    @Test
    public void replaceElemTestString() {
        heapS.insertElem("Sara");
        heapS.insertElem("Chiara");
        heapS.insertElem("Carmine");
        heapS.insertElem("Samuele");
        heapS.insertElem("Antonino");
        heapS.replaceElem("Antonino", "Anastasia");
        assertSame("Anastasia", heapS.getRoot());
    }

    @Test
    public void decreaseElemTestInt() {
        heapI.insertElem(10);
        heapI.insertElem(9);
        heapI.insertElem(1);
        heapI.insertElem(3);
        heapI.insertElem(12);
        heapI.decreaseElem(1, 0);
        assertEquals(0, (int) heapI.getRoot());
    }

    @Test
    public void decreaseElemTestDouble() {
        heapD.insertElem(4.5);
        heapD.insertElem(8.0);
        heapD.insertElem(1.6);
        heapD.insertElem(3.7);
        heapD.insertElem(12.2);
        heapD.decreaseElem(1.6, 0.6);
        assertEquals(0.6, heapD.getRoot(), 0.0);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(HeapMinTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println("\nJUNIT TEST RESULTS : " + result.wasSuccessful() + "\n");
    }
}
