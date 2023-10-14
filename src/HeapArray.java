public class HeapArray {
    Integer [] heap;
    int root;
    int left;
    int right;
    int position;
    int free;

    public HeapArray(){
        heap = new Integer[10];
        root = 0;
        position = 0;
        left = (position * 2) + 1;
        right = (position * 2) + 2;
    }

    public void enqueue(Integer value) throws Exception {
        if(position == heap.length){
            throw new Exception("Heap is full");
        }
        else{
            heap[position] = value;
            position++;
        }
        bubble(position);
    }
    public void dequeue(){

    }

    public void bubble(Integer pos){
        if(parent(position) < pos )

    }

    public int parent(int position){
        return (position  - 1)/2;
    }


}
