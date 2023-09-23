package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1303 {
    static int N, M, white, blue, cnt;
    static char[][] A;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new char[M][N];
        for (int i = 0; i < M; i++) {
            A[i] = br.readLine().toCharArray();
        }
        visit = new boolean[M][N];
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;
        cnt++;

        for (int d = 0; d < 4; d++) {
            int nx = x + dir[d][0];
            int ny = y + dir[d][1];

            if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
            if(visit[nx][ny]) continue;
            if(A[x][y] != A[nx][ny]) continue;

            dfs(nx, ny);
        }
    }

    static void pro() {
        white = 0;
        blue = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(visit[i][j]) continue;
                cnt = 0;
                dfs(i, j);
                if (A[i][j] == 'W') {
                    white += cnt * cnt;
                } else {
                    blue += cnt * cnt;
                }
            }
        }

        System.out.println(white + " " + blue);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
