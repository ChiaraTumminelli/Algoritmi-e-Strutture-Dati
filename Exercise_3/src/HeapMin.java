import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

public class HeapMin<T extends Comparable<T>> {

    private final ArrayList<T> heap;

    // Constructor
    public HeapMin() {
        heap = new ArrayList<>();
    }

    // Return the size of the heap - Time Complexity : O(1);
    public int getSize() {
        return heap.size();
    }

    // Return true if index has parent, false otherwise
    public boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    // Return true if index has left child, false otherwise
    public boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < getSize();
    }

    // Return true if index has right child, false otherwise
    public boolean hasRightChild(int index) {
        return getRightChildIndex(index) < getSize();
    }

    // Return parent of child index - Time Complexity : O(1);
    public int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    // Return left child of parent index - Time Complexity : O(1);
    public int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    // Return right child of parent index - Time Complexity : O(1);
    public int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    // Return parent value of child index
    public T parent(int childIndex) {
        return heap.get(getParentIndex(childIndex));
    }

    // Return left child value of parent index
    public T leftChild(int parentIndex) {
        return heap.get(getLeftChildIndex(parentIndex));
    }

    // Return right child of parent index
    public T rightChild(int parentIndex) {
        return heap.get(getRightChildIndex(parentIndex));
    }

    // Return root element
    public T getRoot() {
        return heap.get(0);
    }

    // Return true if heap is empty, false otherwise
    public boolean isEmpty() {
        return getSize() == 0;
    }

    // Remove all elements from heap
    public void clean() {
        heap.clear();
    }

    // Return element at a certain index
    public int getIndex(T elem) {
        if (!heap.contains(elem))
            throw new NoSuchElementException();
        return heap.indexOf(elem);
    }

    // Print the heap as an array
    public void printAsArray() {
        System.out.println("  Heap: " + heap);
    }

    // Insert an element - Time Complexity : O(log n)
    public void insertElem(T elem) {
        if (!heap.contains(elem)) {
            heap.add(elem);
            int index = getSize() - 1;
            while (hasParent(index) && parent(index).compareTo(heap.get(index)) > 0) {
                Collections.swap(heap, getParentIndex(index), index);
                index = getParentIndex(index);
            }
        }
    }

    // Delete specified element from the heap
    public void deleteElem(T elem) {
        heap.remove(getIndex(elem));
        heapify();
    }

    // Extract element with minimum value - Time complexity : O(log n);
    public T extractMin() {
        if (getSize() == 0)
            throw new NoSuchElementException();
        if (getSize() == 1)
            return heap.remove(0);
        heap.set(0, heap.get(getSize() - 1));
        heap.remove(getSize() - 1);
        heapify();
        return getRoot();
    }

    // Sort elements of heap
    public void heapify() {
        int index = 0;
        while (hasLeftChild(index)) {
            int minChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index).compareTo(leftChild(index)) < 0)
                minChildIndex = getRightChildIndex(index);
            if (heap.get(index).compareTo(heap.get(minChildIndex)) >= 0)
                Collections.swap(heap, index, minChildIndex);
            index = minChildIndex;
        }
    }

    // Replace value of an element
    public void replaceElem(T oldElem, T newElem) {
        if (!heap.contains(oldElem))
            throw new NoSuchElementException();
        heap.set(getIndex(oldElem), newElem);
        heapify();
    }

    // Decreasing value of an element - Time Complexity : O(log n)
    public void decreaseElem(T elem, T t) {
        if (!heap.contains(elem))
            throw new NoSuchElementException();
        final T el = t;
        heap.set(heap.indexOf(elem), el);
        heapify();
    }

}