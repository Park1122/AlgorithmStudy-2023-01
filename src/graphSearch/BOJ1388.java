package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1388 {
    static int N, M;
    static char[][] A;
    static boolean[][] visit;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new char[N][M];
        for (int i = 0; i < N; i++) {
            A[i] = br.readLine().toCharArray();
        }
        visit = new boolean[N][M];
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;

        int nx, ny;
        if (A[x][y] == '-') {
            nx = x;
            ny = y + 1;

            if (ny < M && A[x][y] == A[nx][ny] && !visit[nx][ny]) {
                dfs(nx, ny);
            }
        } else {
            nx = x + 1;
            ny = y;

            if (nx < N && A[x][y] == A[nx][ny] && !visit[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }

    static void pro() {
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visit[i][j]) continue;
                dfs(i, j);
                ans++;
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
