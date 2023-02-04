package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7562 {
    static int L, N, M, ex, ey;
    static int[][] dist;
    static boolean[][] visit;
    static int[][] dir = {{2, 1}, {1, 2}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        L = Integer.parseInt(br.readLine());
        dist = new int[L][L];
        visit = new boolean[L][L];
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ex = Integer.parseInt(st.nextToken());
        ey = Integer.parseInt(st.nextToken());
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

            if(x == ex && y == ey) break;

            for (int d = 0; d < 8; d++) {
                int nx = x + dir[d][0];
                int ny = y + dir[d][1];
                if(nx < 0 || ny < 0 || nx >= L || ny >= L) continue;
                if(visit[nx][ny]) continue;

                q.add(nx);
                q.add(ny);
                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }

    static void pro() {
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                dist[i][j] = -1;
            }
        }

        bfs(N, M);

        sb.append(dist[ex][ey]).append('\n');
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
