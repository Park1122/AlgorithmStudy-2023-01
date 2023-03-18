package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2468 {
    static int N, ans, H;
    static int[][] A;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N][N];
        H = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                H = Math.max(H, A[i][j]);
            }
        }
    }

    static void bfs(int sx, int sy) {
        Queue<Integer> q = new LinkedList<>();
        q.add(sx);
        q.add(sy);
        visit[sx][sy] = true;

        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = x + dir[d][0];
                int ny = y + dir[d][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visit[nx][ny]) continue;

                q.add(nx);
                q.add(ny);
                visit[nx][ny] = true;
            }
        }
    }

    static void sink(int height) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] <= height) {
                    visit[i][j] = true;
                }
            }
        }
    }

    static void pro() {
        for (int h = 0; h <= H; h++) {
            // 잠김
            visit = new boolean[N][N];
            sink(h);

            // 안전구역 구하기
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(visit[i][j]) continue;
                    bfs(i, j);
                    cnt++;
                }
            }

            // 안전구역 개수 갱신
            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
