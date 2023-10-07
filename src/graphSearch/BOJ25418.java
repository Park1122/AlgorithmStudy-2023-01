package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ25418 {
    static int A, K;
    static int[] dist;
    static boolean[] visit;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dist = new int[1_000_001];
        visit = new boolean[1_000_001];
    }

    static void pro() {
        Queue<Integer> q = new LinkedList<>();
        q.add(A);
        visit[A] = true;

        while (!q.isEmpty()) {
            int x = q.poll();

            int nx = x + 1;
            if (nx <= 1_000_000 && !visit[nx]) {
                dist[nx] = dist[x] + 1;
                visit[nx] = true;
                q.add(nx);
            }
            nx = x * 2;
            if (nx <= 1_000_000 && !visit[nx]) {
                dist[nx] = dist[x] + 1;
                visit[nx] = true;
                q.add(nx);
            }
        }

        System.out.println(dist[K]);
    }
}
