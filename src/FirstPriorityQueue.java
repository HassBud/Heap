public class FirstPriorityQueue {

    Node start;
    Node current;
    Node prev;
    Node prevLeast;

    public class Node {
        private int item;
        private Node next;
        private Node(int item) {
            this.item = item;
            this.next = null;
        }

    }

    public void clear() {
        start = null;
    }
    public void add(int prio){
        if(start == null){
            start = new Node(prio);
        }
        else {
            Node newFirstNode = new Node(prio);
            newFirstNode.next = start;
            start = newFirstNode;
        }

    }
    public FirstPriorityQueue(){
        this.start = null;
        current = null;
        prev = null;
        prevLeast = null;
    }



    public void remove() {
        if (isEmpty()) {
            start = null;
            return;
        }
        int remove = Integer.MAX_VALUE; // sätter max value för att
        current = start;
        prev = null;

        while (current != null) {
            if (current.item < remove) {
                remove = current.item;
                prevLeast = prev;
            }
            prev = current;
            current = current.next;
        }
        if (prevLeast != null) {
            if (prevLeast.next.next == null) {
                prevLeast.next = null;
            } else {
                    prevLeast.next = prevLeast.next.next;
            }
        }

        if (start.item == remove){
            start = start.next;
        }


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
