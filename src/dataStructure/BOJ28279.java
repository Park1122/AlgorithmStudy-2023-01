package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ28279 {
    static int N;
    static Deque<Integer> dq;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        dq = new ArrayDeque<>();
        N = Integer.parseInt(br.readLine());
    }

    static void pro() throws IOException {
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if (a == 1) {
                int b = Integer.parseInt(st.nextToken());
                dq.addFirst(b);
            } else if (a == 2) {
                int b = Integer.parseInt(st.nextToken());
                dq.addLast(b);
            } else if (a == 3) {
                if (dq.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(dq.peekFirst()).append('\n');
                    dq.pollFirst();
                }
            } else if (a == 4) {
                if (dq.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(dq.peekLast()).append('\n');
                    dq.pollLast();
                }
            } else if (a == 5) {
                sb.append(dq.size()).append('\n');
            } else if (a == 6) {
                sb.append(dq.isEmpty() ? 1 : 0).append('\n');
            } else if (a == 7) {
                sb.append(dq.isEmpty() ? -1 : dq.peekFirst()).append('\n');
            } else {
                sb.append(dq.isEmpty() ? -1 : dq.peekLast()).append('\n');
            }
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
