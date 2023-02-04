package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18404 {
    static int N, M, X, Y;
    static int[][] dist;
    static boolean[][] visit;
    static int[][] enemies;
    static int[][] dir = {{2, 1}, {1, 2}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N][N];
        visit = new boolean[N][N];
        enemies = new int[M][2];
        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            enemies[i][0] = Integer.parseInt(st.nextToken());
            enemies[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    static void bfs(int sx, int sy) {
        Queue<Integer> q = new LinkedList<>();
        q.add(sx);
        q.add(sy);
        visit[sx][sy] = true;
        dist[sx][sy] = 0;

        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();

            for (int d = 0; d < 8; d++) {
                int nx = x + dir[d][0];
                int ny = y + dir[d][1];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visit[nx][ny]) continue;

                q.add(nx);
                q.add(ny);
                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }

    static void pro() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dist[i][j] = -1;
            }
        }

        bfs(X - 1, Y - 1);

        for (int i = 0; i < M; i++) {
            sb.append(dist[enemies[i][0] - 1][enemies[i][1] - 1]).append(' ');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
