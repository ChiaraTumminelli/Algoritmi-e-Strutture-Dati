import java.util.Scanner;

public class Main {

    public static final String YELLOW_BOLD = "\033[1;33m";
    public static final String RED_BOLD = "\033[1;31m";
    public static final String RESET = "\033[0m";

    public static void applicationInt(HeapMin<Integer> heapI) {

        System.out.println(RED_BOLD + "\n\n Which operation do you want to perform?\n" + RESET);
        System.out.println("  1. Creation of a min heap.");
        System.out.println("  2. Insertion of an element into the heap.");
        System.out.println("  3. Removal of an element from the heap.");
        System.out.println("  4. Check size of heap.");
        System.out.println("  5. Return parent of an element.");
        System.out.println("  6. Return left child of an element.");
        System.out.println("  7. Return right child of an element.");
        System.out.println("  8. Extraction of element with minimum value.");
        System.out.println("  9. Decrease element value.");
        System.out.println(" 10. Replace element with another value.");
        System.out.println(" 11. Remove all elements from heap.");
        System.out.println(" 12. Check if heap is empty.");
        System.out.println(" 13. Change type for testing.");
        System.out.println(" 14. Stop application.\n\n");
        System.out.print("  Your response: ");

        Scanner keyboard = new Scanner(System.in);
        int response = keyboard.nextInt();
        System.out.print("\n");
        switch (response) {

            // Creation of a MinHeap
            case 1:
                System.out.println(YELLOW_BOLD + "  Heap has been created correctly." + RESET);
                heapI.printAsArray();
                applicationInt(heapI);
                break;

            // Insertion of an element into the heap
            case 2:
                System.out.print("  Which value do you want to insert into the heap? ");
                Scanner k = new Scanner(System.in);
                int r = k.nextInt();
                System.out.println(YELLOW_BOLD + "\n  Element has been inserted correctly." + RESET);
                System.out.print("  B");
                heapI.printAsArray();
                heapI.insertElem(r);
                System.out.print("  A");
                heapI.printAsArray();
                applicationInt(heapI);
                break;

            // Removal of an element from the heap
            case 3:
                System.out.print("  Which value do you want to remove from the heap? ");
                Scanner rm = new Scanner(System.in);
                int rme = rm.nextInt();
                System.out.println(YELLOW_BOLD + "\n  Element has been removed correctly." + RESET);
                System.out.print("  B");
                heapI.printAsArray();
                heapI.deleteElem(rme);
                System.out.print("  A");
                heapI.printAsArray();
                applicationInt(heapI);
                break;

            // Check size of heap
            case 4:
                System.out.println(YELLOW_BOLD + "  Size of heap is " + heapI.getSize() + RESET);
                heapI.printAsArray();
                applicationInt(heapI);
                break;

            // Return parent of an element
            case 5:
                System.out.print("  Which element do you want to find the parent of? ");
                Scanner p = new Scanner(System.in);
                int pr = p.nextInt();
                System.out.println("");
                System.out.println(
                        YELLOW_BOLD + "\n  Parent of " + pr + " is " + heapI.parent(heapI.getIndex(pr)) + RESET);
                heapI.printAsArray();
                applicationInt(heapI);
                break;

            // Return left child of an element.
            case 6:
                System.out.print("  Which element do you want to find the left child of? ");
                Scanner s = new Scanner(System.in);
                int sr = s.nextInt();
                System.out.println("");
                System.out.println(
                        YELLOW_BOLD + "\n  Left child of " + sr + " is " + heapI.leftChild(heapI.getIndex(sr))
                                + RESET);
                heapI.printAsArray();
                applicationInt(heapI);
                break;

            // Return right child of an elment
            case 7:
                System.out.print("  Which element do you want to find the right child of? ");
                Scanner c = new Scanner(System.in);
                int cr = c.nextInt();
                System.out.println("");
                System.out.println(
                        YELLOW_BOLD + "\n  Right child of " + cr + " is "
                                + heapI.rightChild(heapI.getIndex(cr)) + RESET);
                heapI.printAsArray();
                applicationInt(heapI);
                break;

            // Extraction of element with minimum value.
            case 8:
                System.out.println(YELLOW_BOLD + "\n  Element has been extracted correctly." + RESET);
                System.out.print("  B");
                heapI.printAsArray();
                heapI.extractMin();
                System.out.print("  A");
                heapI.printAsArray();
                applicationInt(heapI);
                break;

            // Decrease element value
            case 9:
                System.out.print("  Which element do you want to decrease? ");
                Scanner dec = new Scanner(System.in);
                int d = dec.nextInt();
                System.out.println(YELLOW_BOLD + "\n  Element has been decremented correctly." + RESET);
                System.out.print("  B");
                heapI.printAsArray();
                heapI.decreaseElem(d, d - 1);
                System.out.print("  A");
                heapI.printAsArray();
                applicationInt(heapI);
                break;

            // Replace element with another value
            case 10:
                System.out.print("  Which element do you want to replace? ");
                Scanner before = new Scanner(System.in);
                int bf = before.nextInt();
                System.out.print("  Insert new value: ");
                Scanner after = new Scanner(System.in);
                int at = after.nextInt();
                System.out.println("");
                System.out.println(YELLOW_BOLD + "\n  Element has been replaced correctly." + RESET);
                System.out.print("  B");
                heapI.printAsArray();
                heapI.replaceElem(bf, at);
                System.out.print("  A");
                heapI.printAsArray();
                applicationInt(heapI);
                break;

            // Remove all elements from heap
            case 11:
                System.out.println(YELLOW_BOLD + "\n  Heap has been cleaned correctly." + RESET);
                System.out.print("  B");
                heapI.printAsArray();
                heapI.clean();
                System.out.print("  A");
                heapI.printAsArray();
                applicationInt(heapI);
                break;

            // Check if heap is empty
            case 12:
                if (heapI.isEmpty() == true) {
                    System.out.println(YELLOW_BOLD + "  Heap is empty." + RESET);
                } else {
                    System.out.println(YELLOW_BOLD + "  Heap is not empty." + RESET);
                }
                heapI.printAsArray();
                applicationInt(heapI);
                break;

            case 13:
                askTypeApplication();
                break;

            // Stop application
            case 14:
                System.out.println(YELLOW_BOLD + "  Thanks for testing!\n\n" + RESET);
                break;

            default:
                System.out.println(RED_BOLD + "  No valid choice selected, retry!\n\n" + RESET);
                applicationInt(heapI);
                break;
        }
        keyboard.close();
    }

    public static void applicationDouble(HeapMin<Double> heap) {

        System.out.println(RED_BOLD + "\n\n Which operation do you want to perform?\n" + RESET);
        System.out.println("  1. Creation of a min heap.");
        System.out.println("  2. Insertion of an element into the heap.");
        System.out.println("  3. Removal of an element from the heap.");
        System.out.println("  4. Check size of heap.");
        System.out.println("  5. Return parent of an element.");
        System.out.println("  6. Return left child of an element.");
        System.out.println("  7. Return right child of an element.");
        System.out.println("  8. Extraction of element with minimum value.");
        System.out.println("  9. Decrease element value.");
        System.out.println(" 10. Replace element with another value.");
        System.out.println(" 11. Remove all elements from heap.");
        System.out.println(" 12. Check if heap is empty.");
        System.out.println(" 13. Change type for testing.");
        System.out.println(" 14. Stop application.\n\n");
        System.out.print("  Your response: ");

        Scanner keyboard = new Scanner(System.in);
        int response = keyboard.nextInt();
        System.out.print("\n");
        switch (response) {

            // Creation of a MinHeap
            case 1:
                System.out.println(YELLOW_BOLD + "  Heap has been created correctly." + RESET);
                heap.printAsArray();
                applicationDouble(heap);
                break;

            // Insertion of an element into the heap
            case 2:
                System.out.print("  Which value do you want to insert into the heap? ");
                Scanner k = new Scanner(System.in);
                double r = k.nextDouble();
                System.out.println(YELLOW_BOLD + "\n  Element has been inserted correctly." + RESET);
                System.out.print("  B");
                heap.printAsArray();
                heap.insertElem(r);
                System.out.print("  A");
                heap.printAsArray();
                applicationDouble(heap);
                break;

            // Removal of an element from the heap
            case 3:
                System.out.print("  Which value do you want to remove from the heap? ");
                Scanner rm = new Scanner(System.in);
                double rme = rm.nextDouble();
                System.out.println(YELLOW_BOLD + "\n  Element has been removed correctly." + RESET);
                System.out.print("  B");
                heap.printAsArray();
                heap.deleteElem(rme);
                System.out.print("  A");
                heap.printAsArray();
                applicationDouble(heap);
                break;

            // Check size of heap
            case 4:
                System.out.println(YELLOW_BOLD + "  Size of heap is " + heap.getSize() + RESET);
                heap.printAsArray();
                applicationDouble(heap);
                break;

            // Return parent of an element
            case 5:
                System.out.print("  Which element do you want to find the parent of? ");
                Scanner p = new Scanner(System.in);
                double pr = p.nextDouble();
                System.out.println("");
                System.out.println(
                        YELLOW_BOLD + "\n  Parent of " + pr + " is " + heap.parent(heap.getIndex(pr)) + RESET);
                heap.printAsArray();
                applicationDouble(heap);
                break;

            // Return left child of an element.
            case 6:
                System.out.print("  Which element do you want to find the left child of? ");
                Scanner s = new Scanner(System.in);
                double sr = s.nextDouble();
                System.out.println("");
                System.out.println(
                        YELLOW_BOLD + "\n  Left child of " + sr + " is " + heap.leftChild(heap.getIndex(sr))
                                + RESET);
                heap.printAsArray();
                applicationDouble(heap);
                break;

            // Return right child of an elment
            case 7:
                System.out.print("  Which element do you want to find the right child of? ");
                Scanner c = new Scanner(System.in);
                double cr = c.nextDouble();
                System.out.println("");
                System.out.println(
                        YELLOW_BOLD + "\n  Right child of " + cr + " is "
                                + heap.rightChild(heap.getIndex(cr)) + RESET);
                heap.printAsArray();
                applicationDouble(heap);
                break;

            // Extraction of element with minimum value.
            case 8:
                System.out.println(YELLOW_BOLD + "\n  Element has been extracted correctly." + RESET);
                System.out.print("  B");
                heap.printAsArray();
                heap.extractMin();
                System.out.print("  A");
                heap.printAsArray();
                applicationDouble(heap);
                break;

            // Decrease element value
            case 9:
                System.out.print("  Which element do you want to decrease? ");
                Scanner dec = new Scanner(System.in);
                double d = dec.nextDouble();
                System.out.println(YELLOW_BOLD + "\n  Element has been decremented correctly." + RESET);
                System.out.print("  B");
                heap.printAsArray();
                heap.decreaseElem(d, d - 1);
                System.out.print("  A");
                heap.printAsArray();
                applicationDouble(heap);
                break;

            // Replace element with another value
            case 10:
                System.out.print("  Which element do you want to replace? ");
                Scanner before = new Scanner(System.in);
                double bf = before.nextDouble();
                System.out.print("  Insert new value: ");
                Scanner after = new Scanner(System.in);
                double at = after.nextDouble();
                System.out.println("");
                System.out.println(YELLOW_BOLD + "\n  Element has been replaced correctly." + RESET);
                System.out.print("  B");
                heap.printAsArray();
                heap.replaceElem(bf, at);
                System.out.print("  A");
                heap.printAsArray();
                applicationDouble(heap);
                break;

            // Remove all elements from heap
            case 11:
                System.out.println(YELLOW_BOLD + "\n  Heap has been cleaned correctly." + RESET);
                System.out.print("  B");
                heap.printAsArray();
                heap.clean();
                System.out.print("  A");
                heap.printAsArray();
                applicationDouble(heap);
                break;

            // Check if heap is empty
            case 12:
                if (heap.isEmpty() == true) {
                    System.out.println(YELLOW_BOLD + "  Heap is empty." + RESET);
                } else {
                    System.out.println(YELLOW_BOLD + "  Heap is not empty." + RESET);
                }
                heap.printAsArray();
                applicationDouble(heap);
                break;

            case 13:
                askTypeApplication();
                break;

            // Stop application
            case 14:
                System.out.println(YELLOW_BOLD + "  Thanks for testing!\n\n" + RESET);
                break;

            default:
                System.out.println(RED_BOLD + "  No valid choice selected, retry!\n\n" + RESET);
                applicationDouble(heap);
                break;
        }
        keyboard.close();
    }

    public static void applicationString(HeapMin<String> heap) {

        System.out.println(RED_BOLD + "\n\n Which operation do you want to perform?\n" + RESET);
        System.out.println("  1. Creation of a min heap.");
        System.out.println("  2. Insertion of an element into the heap.");
        System.out.println("  3. Removal of an element from the heap.");
        System.out.println("  4. Check size of heap.");
        System.out.println("  5. Return parent of an element.");
        System.out.println("  6. Return left child of an element.");
        System.out.println("  7. Return right child of an element.");
        System.out.println("  8. Extraction of element with minimum value.");
        System.out.println("  9. Replace element with another value.");
        System.out.println(" 10. Remove all elements from heap.");
        System.out.println(" 11. Check if heap is empty.");
        System.out.println(" 12. Change type for testing.");
        System.out.println(" 13. Stop application.\n\n");
        System.out.print("  Your response: ");

        Scanner keyboard = new Scanner(System.in);
        int response = keyboard.nextInt();
        System.out.print("\n");
        switch (response) {

            // Creation of a MinHeap
            case 1:
                System.out.println(YELLOW_BOLD + "  Heap has been created correctly." + RESET);
                heap.printAsArray();
                applicationString(heap);
                break;

            // Insertion of an element into the heap
            case 2:
                System.out.print("  Which value do you want to insert into the heap? ");
                Scanner k = new Scanner(System.in);
                String r = k.nextLine();
                System.out.println(YELLOW_BOLD + "\n  Element has been inserted correctly." + RESET);
                System.out.print("  B");
                heap.printAsArray();
                heap.insertElem(r);
                System.out.print("  A");
                heap.printAsArray();
                applicationString(heap);
                break;

            // Removal of an element from the heap
            case 3:
                System.out.print("  Which value do you want to remove from the heap? ");
                Scanner rm = new Scanner(System.in);
                String rme = rm.nextLine();
                System.out.println(YELLOW_BOLD + "\n  Element has been removed correctly." + RESET);
                System.out.print("  B");
                heap.printAsArray();
                heap.deleteElem(rme);
                System.out.print("  A");
                heap.printAsArray();
                applicationString(heap);
                break;

            // Check size of heap
            case 4:
                System.out.println(YELLOW_BOLD + "  Size of heap is " + heap.getSize() + RESET);
                heap.printAsArray();
                applicationString(heap);
                break;

            // Return parent of an element
            case 5:
                System.out.print("  Which element do you want to find the parent of? ");
                Scanner p = new Scanner(System.in);
                String pr = p.nextLine();
                System.out.println("");
                System.out.println(
                        YELLOW_BOLD + "\n  Parent of " + pr + " is " + heap.parent(heap.getIndex(pr)) + RESET);
                heap.printAsArray();
                applicationString(heap);
                break;

            // Return left child of an element.
            case 6:
                System.out.print("  Which element do you want to find the left child of? ");
                Scanner s = new Scanner(System.in);
                String sr = s.nextLine();
                System.out.println("");
                System.out.println(
                        YELLOW_BOLD + "\n  Left child of " + sr + " is " + heap.leftChild(heap.getIndex(sr))
                                + RESET);
                heap.printAsArray();
                applicationString(heap);
                break;

            // Return right child of an elment
            case 7:
                System.out.print("  Which element do you want to find the right child of? ");
                Scanner c = new Scanner(System.in);
                String cr = c.nextLine();
                System.out.println("");
                System.out.println(
                        YELLOW_BOLD + "\n  Right child of " + cr + " is "
                                + heap.rightChild(heap.getIndex(cr)) + RESET);
                heap.printAsArray();
                applicationString(heap);
                break;

            // Extraction of element with minimum value.
            case 8:
                System.out.println(YELLOW_BOLD + "\n  Element has been extracted correctly." + RESET);
                System.out.print("  B");
                heap.printAsArray();
                heap.extractMin();
                System.out.print("  A");
                heap.printAsArray();
                applicationString(heap);
                break;

            // Replace element with another value
            case 9:
                System.out.print("  Which element do you want to replace? ");
                Scanner before = new Scanner(System.in);
                String bf = before.nextLine();
                System.out.print("  Insert new value: ");
                Scanner after = new Scanner(System.in);
                String at = after.nextLine();
                System.out.println("");
                System.out.println(YELLOW_BOLD + "\n  Element has been replaced correctly." + RESET);
                System.out.print("  B");
                heap.printAsArray();
                heap.replaceElem(bf, at);
                System.out.print("  A");
                heap.printAsArray();
                applicationString(heap);
                break;

            // Remove all elements from heap
            case 10:
                System.out.println(YELLOW_BOLD + "\n  Heap has been cleaned correctly." + RESET);
                System.out.print("  B");
                heap.printAsArray();
                heap.clean();
                System.out.print("  A");
                heap.printAsArray();
                applicationString(heap);
                break;

            // Check if heap is empty
            case 11:
                if (heap.isEmpty() == true) {
                    System.out.println(YELLOW_BOLD + "  Heap is empty." + RESET);
                } else {
                    System.out.println(YELLOW_BOLD + "  Heap is not empty." + RESET);
                }
                heap.printAsArray();
                applicationString(heap);
                break;

            case 12:
                askTypeApplication();
                break;

            // Stop application
            case 13:
                System.out.println(YELLOW_BOLD + "  Thanks for testing!\n\n" + RESET);
                break;

            default:
                System.out.println(RED_BOLD + "  No valid choice selected, retry!\n\n" + RESET);
                applicationString(heap);
                break;
        }
        keyboard.close();
    }

    public static void askTypeApplication() {
        HeapMin<Integer> heapI = new HeapMin<>();
        HeapMin<Double> heapD = new HeapMin<>();
        HeapMin<String> heapS = new HeapMin<>();
        System.out.println(RED_BOLD + "\n\n Which type do you want to test?\n" + RESET);
        System.out.println("  1. Integer.");
        System.out.println("  2. Double.");
        System.out.println("  3. String.\n\n");
        System.out.print("  Your response: ");
        Scanner keyboard = new Scanner(System.in);
        int response = keyboard.nextInt();
        System.out.print("\n");
        switch (response) {
            case 1:
                applicationInt(heapI);
                break;
            case 2:
                applicationDouble(heapD);
                break;
            case 3:
                applicationString(heapS);
                break;
            default:
                System.out.println(RED_BOLD + "  No valid choice selected, retry!\n\n" + RESET);
                break;
        }
        keyboard.close();
    }

    public static void main(String[] args) {
        askTypeApplication();
    }
}