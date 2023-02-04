package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569 {
    static int N, M, H;
    static int[][][] dist, A;
    static int[][] dir = {{1, 0, 0}, {0, 1, 0}, {-1, 0, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        dist = new int[H + 1][N + 1][M + 1];
        A = new int[H + 1][N + 1][M + 1];
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= M; k++) {
                    A[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= M; k++) {
                    dist[i][j][k] = -1;
                    if (A[i][j][k] == 1) {
                        q.add(i);
                        q.add(j);
                        q.add(k);
                        dist[i][j][k] = 0;
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int h = q.poll();
            int i = q.poll();
            int j = q.poll();
            for (int d = 0; d < 6; d++) {
                int nh = h + dir[d][0];
                int ni = i + dir[d][1];
                int nj = j + dir[d][2];

                if(nh < 1 || ni < 1 || nj < 1 || nh > H || ni > N || nj > M) continue;
                if(A[nh][ni][nj] == -1) continue;
                if(dist[nh][ni][nj] != -1) continue;

                q.add(nh);
                q.add(ni);
                q.add(nj);
                dist[nh][ni][nj] = dist[h][i][j] + 1;
            }
        }
    }

    static void pro() {
        bfs();

        int ans = 0;
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= M; k++) {
                    if(A[i][j][k] == -1) continue;
                    if (dist[i][j][k] == -1) {
                        System.out.println(-1);
                        return;
                    }

                    ans = Math.max(dist[i][j][k], ans);
                }
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
