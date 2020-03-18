package linkedlist;

public class LinkedlistTest {
    public static void main(String[] args) {
        Linkedlist list = new Linkedlist();
        list.addFirstNode("jamie");
        list.printList();
        list.addFirstNode("Jin");
        list.printList();
        list.addFirstNode("Jeremy");
        list.printList();

        System.out.println(list.getNode("jamie"));
    }
}