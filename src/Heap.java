public class Heap {

    private class Node {
        public Integer key;
        public Integer prio;
        public Node left, right;
        int size;


        public Node(Integer prio) {
            this.prio = prio;
            this.left = this.right = null;
            size = 1;

        }

        public void add(Integer priority) {
            size += 1;
            if (priority < prio) {
                int temp = prio;
                prio = priority;
                priority = temp;
            }
            if (left == null) {
                left = new Node(priority);
                return;
            }
            if (right == null) {
                right = new Node(priority);
                return;
            }
            if (left.size < right.size)
                left.add(priority);
            else
                right.add(priority);
        }

        public Node remove() {
            size--;
            if (left == null)
                return right;
            else if (right == null)
                return left;
            else if (right.prio < left.prio) {
                prio = right.prio;
                right = right.remove();
                return right;
            } else {
                prio = left.prio;
                left = left.remove();
                return left;
            }
        }

        public void swap(Node direction){
            int temp = prio;
            prio = direction.prio;
            direction.prio = temp;
        }

        public int push(){

            if(left == null && right == null){
                return 0;
            }
            sizeHeap++;
            if(right == null){
                if(prio > left.prio) {
                    swap(left);
                    left.push();
                }
                 return sizeHeap;
            }
            else if (left == null){
                if(prio > right.prio){
                    swap(right);
                    right.push();
                }
                   return sizeHeap;
            }
            else if(left.prio < right.prio){
                if(left.prio < prio){
                swap(left);
                left.push();
                }
                return sizeHeap;
            }
            else {
                if(right.prio < prio){
                    swap(right);
                    right.push();
                }
                return sizeHeap;
            }

        }
    }



    Node root;
    Node current;
    Integer currentValue;
    int sizeHeap;


    public Heap(){
        root = null;
        current = null;
        currentValue = 0;
        sizeHeap = 0;
    }


    public void enqueue(Integer prio){
        if(root == null){
            root = new Node(prio);
        }
        else{
            root.add(prio);
        }
    }


    public int dequeue() {
        if (root == null){
            return -1;
        }
        int p = root.prio;
        root = root.remove();
        return p;
    }

    public Integer push(Integer incr){
        if(root == null){
            return null;
        }
        root.prio += incr;
        root.push();
        return sizeHeap;
    }

    public void printTree() {
        if (root == null) {
            System.out.println("The tree is empty.");
        } else {
            printTreeRecursive(root, 0);
        }
    }

    private void printTreeRecursive(Node node, int depth) {
        if (node == null) {
            return;
        }

        // Print right child
        printTreeRecursive(node.right, depth + 1);

        // Print current node
        for (int i = 0; i < depth; i++) {
            System.out.print("   ");
        }
        System.out.println(node.prio);

        // Print left child
        printTreeRecursive(node.left, depth + 1);
    }


}


