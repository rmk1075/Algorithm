package queue;

import java.util.Comparator;
import java.util.PriorityQueue;

class Student implements Comparable<Student> {
    int id, score;
    public Student(int id, int score) {
        this.id = id;
        this.score = score;
    }

    @Override
    public String toString() {
        return "id: " + this.id + ", score: " + this.score;
    }

    @Override
    public int compareTo(Student o) {        
        return this.id - o.id;
    }
}

public class PriorityQueueTest {
    public static void main(String[] args) {
        // PriorityQueue<Student> queue = new PriorityQueue<>();
        PriorityQueue<Student> queue = new PriorityQueue<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.score - o2.score;
            }
        });
        
        queue.offer(new Student(10, 100));
        queue.offer(new Student(1, 80));
        queue.offer(new Student(5, 50));

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}