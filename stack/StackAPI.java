package stack;

import java.util.Stack;

public class StackAPI {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        stack.push("jamie");
        stack.push("jeremy");
        stack.push("david");

        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }
}