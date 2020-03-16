package queue;

import java.util.Arrays;
import java.util.Comparator;

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

public class ComparableTest {
    public static void main(String[] args) {
        Student[] students = new Student[] {
            new Student(1, 100), new Student(10, 50), new Student(5, 10)
        };

        Arrays.sort(students);
        for(Student student : students) System.out.println(student);

        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {                
                return o2.score - o1.score;
            }
        });
        for(Student student : students) System.out.println(student);
    }
}