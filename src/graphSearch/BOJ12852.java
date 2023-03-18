package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ12852 {
    static int N;
    static boolean[] visit;
    static int[] dist, parents;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N + 1];
        parents = new int[N + 1];
        dist = new int[N + 1];
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start] = true;
        dist[start] = 0;
        parents[start] = -1;

        while (!q.isEmpty()) {
            int x = q.poll();

            int nx = x * 3;
            if (nx <= N && !visit[nx]) {
                q.add(nx);
                visit[nx] = true;
                dist[nx] = dist[x] + 1;
                parents[nx] = x;
            }
            nx = x * 2;
            if (nx <= N && !visit[nx]) {
                q.add(nx);
                visit[nx] = true;
                dist[nx] = dist[x] + 1;
                parents[nx] = x;
            }
            nx = x + 1;
            if (nx <= N && !visit[nx]) {
                q.add(nx);
                visit[nx] = true;
                dist[nx] = dist[x] + 1;
                parents[nx] = x;
            }
        }
    }

    static void pro() {
        for (int i = 0; i <= N; i++) {
            dist[i] = -1;
        }
        bfs(1);

        sb.append(dist[N]).append('\n');
        while (parents[N] != -1) {
            sb.append(N).append(' ');
            N = parents[N];
        }
        sb.append(1);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
