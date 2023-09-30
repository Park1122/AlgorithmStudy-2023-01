package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ12761 {
    static int A, B, N, M;
    static int[] dist;
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
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[100001];
    }

    static void pro() {
        for (int i = 0; i <= 100000; i++) {
            dist[i] = -1;
        }
        bfs(N);
        System.out.println(dist[M]);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int x = q.poll();

            int nx = x + 1;
            if (nx <= 100000 && dist[nx] == -1) {
                dist[nx] = dist[x] + 1;
                q.add(nx);
            }
            nx = x - 1;
            if (nx >= 0 && dist[nx] == -1) {
                dist[nx] = dist[x] + 1;
                q.add(nx);
            }
            nx = x + A;
            if (nx <= 100000 && dist[nx] == -1) {
                dist[nx] = dist[x] + 1;
                q.add(nx);
            }
            nx = x - A;
            if (nx >= 0 && dist[nx] == -1) {
                dist[nx] = dist[x] + 1;
                q.add(nx);
            }
            nx = x + B;
            if (nx <= 100000 && dist[nx] == -1) {
                dist[nx] = dist[x] + 1;
                q.add(nx);
            }
            nx = x - B;
            if (nx >= 0 && dist[nx] == -1) {
                dist[nx] = dist[x] + 1;
                q.add(nx);
            }
            nx = x * A;
            if (nx <= 100000 && dist[nx] == -1) {
                dist[nx] = dist[x] + 1;
                q.add(nx);
            }
            nx = x * B;
            if (nx <= 100000 && dist[nx] == -1) {
                dist[nx] = dist[x] + 1;
                q.add(nx);
            }
        }
    }
}
