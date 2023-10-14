public class HeapArray {
    Integer [] heap;
    int index;


    public HeapArray(){
        heap = new Integer[10];

        index = 0;

    }

    public void enqueue(int value) throws Exception {
        if(index >= heap.length){
            throw new Exception("Heap is full");
        }
        heap[index] = value;
        bubble(index);
        index++;

    }
    public void dequeue(){

    }

    public void bubble(Integer position){
        if(position == null) {
            return;
        }
        int parentIndex = parent(position);
        if(heap[position] < heap[parentIndex] ){
           int temp = heap[parentIndex];
           heap[parentIndex] = heap[position];
           heap[position] = temp;
            bubble(parentIndex);
        }
    }

    public int parent(int position){
        return ((position)  - 1)/2;
    }

    public void printHeap() {
        if (heap.length == 0) {
            System.out.println("Heap is empty.");
            return;
        }

        System.out.print("Heap: ");
        for (int i = 0; i < heap.length; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }


}
