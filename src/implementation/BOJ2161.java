package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2161 {
    static int N;
    static Queue<Integer> q;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        q = new LinkedList<>();
    }

    static void pro() {
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        while (q.size() > 1) {
            sb.append(q.poll()).append(' ');
            q.add(q.poll());
        }
        sb.append(q.poll());
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
