package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697 {
    static int N, K;
    static int[] dist;
    static boolean[] visit;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dist = new int[100001];
        visit = new boolean[100001];
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start] = true;
        dist[start] = 0;

        while (!q.isEmpty()) {
            int x = q.poll();

            if (x - 1 >= 0 && !visit[x - 1]) {
                q.add(x - 1);
                visit[x - 1] = true;
                dist[x - 1] = dist[x] + 1;
            }
            if (x + 1 <= 100000 && !visit[x + 1]) {
                q.add(x + 1);
                visit[x + 1] = true;
                dist[x + 1] = dist[x] + 1;
            }
            if (2 * x <= 100000 && !visit[2 * x]) {
                q.add(2 * x);
                visit[2 * x] = true;
                dist[2 * x] = dist[x] + 1;
            }
        }
    }

    static void pro() {
        bfs(N);
        System.out.println(dist[K]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
