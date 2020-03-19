package tree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(10);
        for(int i = 0; i < 10; i++) tree.add((char)('A' + i));

        tree.searchBFS();
        tree.searchPreOrder();
        tree.searchInOrder();
        tree.searchProstOrder();
    }
}