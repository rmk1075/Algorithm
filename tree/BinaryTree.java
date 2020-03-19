package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private final int SIZE;
    private int lastIdx;
    private Object[] nodes;

    public BinaryTree(int size) {
        nodes = new Object[size+1];
        this.SIZE = size;
    }

    public boolean isEmpty() {
        return lastIdx == 0;
    }

    public boolean isFull() {
        return lastIdx == SIZE;
    }

    public void add(Object obj) {
        if(isFull()) {
            System.out.println("tree is full");
            return ;
        }

        nodes[++lastIdx] = obj;
    }

    public void searchPreOrder() {
        searchPreOrder(1);
        System.out.println();
    }

    public void searchInOrder() {
        searchInOrder(1);
        System.out.println();
    }

    public void searchProstOrder() {
        searchPostOrder(1);
        System.out.println();
    }

    private void searchPreOrder(int index) {
        if(index <= lastIdx) {
            System.out.print(nodes[index] + " ");
            searchPreOrder(index*2);
            searchPreOrder(index*2+1);
        }
    }

    private void searchInOrder(int index) {
        if(index <= lastIdx) {
            searchInOrder(index*2);
            System.out.print(nodes[index] + " ");
            searchInOrder(index*2+1);
        }
    }

    private void searchPostOrder(int index) {
        if(index <= lastIdx) {
            searchPostOrder(index*2);
            searchPostOrder(index*2+1);
            System.out.print(nodes[index] + " ");
        }
    }

    public void searchBFS() {
        if(isEmpty()) return ;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(0 < size--) {
                int current = queue.poll();
                System.out.print(nodes[current] + " ");
    
                if(current*2 <= lastIdx) queue.offer(current*2);
                if(current*2+1 <= lastIdx) queue.offer(current*2+1);
            }
            System.out.println();
        }
    }
}