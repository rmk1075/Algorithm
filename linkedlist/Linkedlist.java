package linkedlist;

public class Linkedlist {
    static class Node {
        Object data;
        Node link; // pointer to next node
        
        public Node(Object data, Node link) {
            this.data = data;
            this.link = link;
        }

        @Override
        public String toString() {
            return "Node: data = " + data + ", link = " + link;
        }
    }
    
    private Node head; // node of linkedlist

    public void addFirstNode(Object data) {
        head = new Node(data, head);
    }

    public Node getNode(Object data) {
        Node currentNode = head;
        while(currentNode != null) {
            if(currentNode.data.equals(data)) return currentNode;
            currentNode = currentNode.link;
        }
        return null;
    }

    public void printList() {
        Node currentNode = head;
        while(currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.link;
        }
        System.out.println();
    }

    

}