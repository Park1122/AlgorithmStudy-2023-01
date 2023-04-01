package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16928 {
    static int N, M;
    static int[] A, dist;
    static boolean[] visit;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[101];
        dist = new int[101];
        visit = new boolean[101];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            A[x] = y;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            A[x] = y;
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;
        visit[start] = true;

        while (!q.isEmpty()) {
            int x = q.poll();
            if (x == 100) {
                return;
            }
            for (int d = 1; d <= 6; d++) {
                int nx = x + d;
                if(nx > 100) continue;
                if(visit[nx]) continue;

                if (A[nx] != 0) {
                    // 사다리 or 뱀 타고 이동
                    if(visit[A[nx]]) continue;
                    q.add(A[nx]);
                    visit[A[nx]] = true;
                    dist[A[nx]] = dist[x] + 1;
                } else {
                    q.add(nx);
                    visit[nx] = true;
                    dist[nx] = dist[x] + 1;
                }
            }
        }
    }

    static void pro() {
        for (int i = 1; i <= 100; i++) {
            dist[i] = -1;
        }
        bfs(1);
        System.out.println(dist[100]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
