package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ9019 {
    static int A, B;
    static String[] dist;
    static boolean[] visit;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        dist = new String[10000];
        visit = new boolean[10000];
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start] = true;

        while (!q.isEmpty()) {
            int x = q.poll();
            int D = (2 * x) % 10000;
            int S = (x == 0) ? 9999 : (x - 1);
            int L = (x % 1000) * 10 + x / 1000;
            int R = (x % 10) * 1000 + x / 10;

            if (!visit[D]) {
                q.add(D);
                visit[D] = true;
                dist[D] = dist[x] + "D";
            }
            if (!visit[S]) {
                q.add(S);
                visit[S] = true;
                dist[S] = dist[x] + "S";
            }
            if (!visit[L]) {
                q.add(L);
                visit[L] = true;
                dist[L] = dist[x] + "L";
            }
            if (!visit[R]) {
                q.add(R);
                visit[R] = true;
                dist[R] = dist[x] + "R";
            }
        }
    }

    static void pro() {
        for (int i = 0; i < 10000; i++) {
            dist[i] = "";
        }

        bfs(A);
        sb.append(dist[B]).append('\n');
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input();
            pro();
        }
        System.out.println(sb.toString());
    }
}
