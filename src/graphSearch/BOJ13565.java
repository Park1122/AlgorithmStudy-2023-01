package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13565 {
    static int M, N;
    static char[][] A;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        A = new char[M][N];
        for (int i = 0; i < M; i++) {
            A[i] = br.readLine().toCharArray();
        }
        visit = new boolean[M][N];
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;

        if (x == M - 1) {
            System.out.println("YES");
            System.exit(0);
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dir[d][0];
            int ny = y + dir[d][1];

            if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
            if(A[nx][ny] == '1') continue;
            if(visit[nx][ny]) continue;

            dfs(nx, ny);
        }
    }

    static void pro() {
        for (int i = 0; i < N; i++) {
            if(A[0][i] == '1' || visit[0][i]) continue;
            dfs(0, i);
        }

        System.out.println("NO");
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
