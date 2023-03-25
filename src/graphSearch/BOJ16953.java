package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16953 {
    static class Node {
        long x;
        int cnt;

        public Node(long x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }

    static long A, B;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
    }

    static void bfs(long start) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.x == B) {
                System.out.println(now.cnt + 1);
                return;
            }

            long nx = now.x * 2;
            if (nx <= B) {
                q.add(new Node(nx, now.cnt + 1));
            }

            nx = now.x * 10 + 1;
            if (nx <= B) {
                q.add(new Node(nx, now.cnt + 1));
            }
        }

        System.out.println(-1);
    }

    static void pro() {
        bfs(A);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
