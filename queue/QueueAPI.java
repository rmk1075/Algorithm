package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueAPI {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        System.out.println(queue.isEmpty() + " / " + queue.size());
        queue.offer("aaa");
        queue.offer("bbb");
        queue.offer("ccc");
        System.out.println(queue.isEmpty() + " / " + queue.size());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.isEmpty() + " / " + queue.size());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.isEmpty() + " / " + queue.size());
    }
}