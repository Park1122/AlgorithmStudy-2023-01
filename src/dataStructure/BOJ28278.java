package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ28278 {
    static int N;
    static Stack<Integer> stack;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        stack = new Stack<>();
        N = Integer.parseInt(br.readLine());
    }

    static void pro() throws IOException {
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if (a == 1) {
                int b = Integer.parseInt(st.nextToken());
                stack.add(b);
            } else if (a == 2) {
                if (stack.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(stack.peek()).append('\n');
                    stack.pop();
                }
            } else if (a == 3) {
                sb.append(stack.size()).append('\n');
            } else if (a == 4) {
                sb.append(stack.isEmpty() ? 1 : 0).append('\n');
            } else {
                sb.append(stack.isEmpty() ? -1 : stack.peek()).append('\n');
            }
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
