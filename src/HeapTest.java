public class HeapTest {
    public static void main(String[] arg) throws Exception {

      /*  Heap heap = new Heap();

        heap.enqueue(20);
        heap.enqueue(10);
        heap.enqueue(2);
        heap.enqueue(90);
        heap.enqueue(16);
        heap.enqueue(95);
        System.out.println(heap.push(15));
        heap.dequeue();
        heap.printTree();

       */

        HeapArray heapArray = new HeapArray();
        heapArray.enqueue(3);
        heapArray.enqueue(5);
        heapArray.enqueue(6);
        heapArray.enqueue(10);
        heapArray.enqueue(1);
        heapArray.dequeue();
        heapArray.printHeap();
        heapArray.dequeue();
        heapArray.printHeap();
        heapArray.dequeue();
        heapArray.printHeap();

    }
}
