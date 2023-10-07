package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ24446 {
    static int N, M, R;
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
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
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        visit = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        dist = new int[N + 1];
    }

    static void pro() {
        for (int i = 1; i <= N; i++) {
            dist[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(R);
        visit[R] = true;
        dist[R] = 0;

        while (!q.isEmpty()) {
            int x = q.poll();

            for (int nx : graph[x]) {
                if(visit[nx]) continue;
                dist[nx] = dist[x] + 1;
                visit[nx] = true;
                q.add(nx);
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(dist[i]).append('\n');
        }
        System.out.println(sb.toString());
    }
}
