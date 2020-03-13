/**
 * visit -> forward, backward
 * stack
 */

package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class VisitStack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String current = "http://www.google.com";
        Stack<String> backStack = new Stack<>();
        Stack<String> forStack = new Stack<>();

        loop: while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken().charAt(0)) {
                case 'Q':
                    break loop;

                case 'V':
                    forStack.clear();
                    backStack.push(current);
                    current = st.nextToken();
                    break;

                case 'B':
                    if(backStack.isEmpty()) break;
                    
                    forStack.push(current);
                    current = backStack.pop();
                    break;

                case 'F':
                    if(forStack.isEmpty()) break;

                    backStack.push(current);
                    current = forStack.pop();
                    break;
            }
            System.out.println(current);
        }
    }
}