public class SecondPriorityQueue {
    private Node start;
    private Node prev;
    private Node current;
    private Node prevLast;
    int addInt = 0;
    private int lengthOfQueue;


    private class Node {
        private int item;
        private Node next;
        private Node(int item, Node next) {
            this.item = item;
            this.next = next;
        }

    }

    public SecondPriorityQueue(){
        this.start = null;
        this.prev = null;
        this.current = null;
        this.prevLast = null;
    }


    public void add(int prio){

        if(isEmpty()) {
            start = new Node(prio, null);
            return;
        }
        current = start;
        prev = null;

        while(current != null){
            if (prio < current.item) {
                Node node = new Node(prio, current);
                if (prev != null) {
                    prev.next = node;
                    break;
                } else {
                    start = node;
                    break;
                }
            }
            else if (current.next == null) {
            Node node = new Node(prio,null );
            current.next = node;
            break;
        }
            prev = current;
            current = current.next;

        }





    }

    public int remove(){
        int remove = start.item;
        start = start.next;
        return remove;
    }


    public boolean isEmpty(){
        return start == null; // looks if the stack is empty
    }

    public void printLinkedList() {
        Node currentNode = start;

        while (currentNode != null) {
            System.out.print(currentNode.item + " -> ");
            currentNode = currentNode.next;
        }

        System.out.println("null");
    }

}
