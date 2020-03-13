package stack;

import java.util.Stack;

public class PostExpression {
    public static void main(String[] args) {
        String exp = "6528-*2/+";
        Stack<Integer> stack = new Stack<>();

        System.out.println(exp);
        int size = exp.length();
        for(int i = 0; i < size; i++) {
            char ch = exp.charAt(i);

            // operand
            if(Character.isDigit(ch)) {
                stack.push(ch - '0');
                continue;
            }

            // operator
            int b = stack.pop(), a = stack.pop();
            switch(ch) {
                case '+':
                    stack.push(a + b);
                    break;
                case '-':
                    stack.push(a - b);
                    break;
                case '*':
                    stack.push(a * b);
                    break;
                case '/':
                    stack.push(a / b);
            }
        }

        System.out.println(stack.pop());;
    }
}