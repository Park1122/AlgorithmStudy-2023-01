package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5014 {
    static int F, S, G, U, D;
    static int[] dist;
    static boolean[] visit;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        dist = new int[F + 1];
        visit = new boolean[F + 1];
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;
        visit[start] = true;

        while (!q.isEmpty()) {
            int x = q.poll();

            int nx = x + U;
            if (nx <= F && !visit[nx]) {
                q.add(nx);
                visit[nx] = true;
                dist[nx] = dist[x] + 1;
            }
            nx = x - D;
            if (nx >= 1 && !visit[nx]) {
                q.add(nx);
                visit[nx] = true;
                dist[nx] = dist[x] + 1;
            }
        }
    }

    static void pro() {
        for (int i = 1; i <= F; i++) {
            dist[i] = -1;
        }
        bfs(S);

        if (visit[G]) {
            System.out.println(dist[G]);
        } else {
            System.out.println("use the stairs");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
