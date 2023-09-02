package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ12789 {
    static int N;
    static Queue<Integer> q;
    static Stack<Integer> stack;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        q = new LinkedList<>();
        stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            q.add(Integer.parseInt(st.nextToken()));
        }
    }

    static void pro() {
        int start = 1; // 간식 먹는 순서

        while (!q.isEmpty()) {
            if (q.peek() == start) {
                q.poll();
                start++;
            } else if (!stack.isEmpty() && stack.peek() == start) {
                stack.pop();
                start++;
            } else {
                stack.push(q.poll());
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == start) {
                stack.pop();
                start++;
            } else {
                System.out.println("Sad");
                return;
            }
        }
        System.out.println("Nice");
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
