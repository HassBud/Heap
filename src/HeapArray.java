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
    public Integer dequeue() throws Exception {
        int ret = heap[0];
        if(heap[0] == 0){
            throw new Exception("Heap is empty");
        }
        heap[0] = heap[index-1];
        heap[index-1] = null;
        sink(0);
        index--;
        return ret;
    }

    private void sink(Integer position) {
        Integer left = (position * 2)+1;
        Integer right = (position * 2) +2;

        if(position == null){
            return;
        }
        if(left <= heap.length-1) {
            if (heap[left] < heap[position]) {
                int temp = heap[position];
                heap[position] = heap[left];
                heap[left] = temp;
                sink(left);
            }
        }
        if (right <= heap.length-1) {
            if (heap[right] < heap[position]) {
                int temp = heap[position];
                heap[position] = heap[right];
                heap[right] = temp;
                sink(right);
            }
        }
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
