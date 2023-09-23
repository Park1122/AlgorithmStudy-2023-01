package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16948 {
    static int N, sx, sy, ex, ey;
    static int[][] A;
    static int[][] dir = {{-2, -1}, {-2, 1}, {0, -2}, {0, 2}, {2, -1}, {2, 1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());
        ex = Integer.parseInt(st.nextToken());
        ey = Integer.parseInt(st.nextToken());
        A = new int[N][N];
    }

    static void bfs(int sx, int sy) {
        Queue<Integer> q = new LinkedList<>();
        q.add(sx);
        q.add(sy);
        A[sx][sy] = 0;

        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();

            for (int d = 0; d < 6; d++) {
                int nx = x + dir[d][0];
                int ny = y + dir[d][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(A[nx][ny] != -1) continue;

                q.add(nx);
                q.add(ny);
                A[nx][ny] = A[x][y] + 1;
            }
        }
    }

    static void pro() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = -1;
            }
        }
        bfs(sx, sy);
        System.out.println(A[ex][ey]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
