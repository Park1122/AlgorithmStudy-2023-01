package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1926 {
    static int N, M, cnt, max, temp;
    static int[][] A;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit = new boolean[N][M];
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;
        temp++;

        for (int d = 0; d < 4; d++) {
            int nx = x + dir[d][0];
            int ny = y + dir[d][1];
            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(visit[nx][ny]) continue;
            if(A[nx][ny] == 0) continue;

            dfs(nx, ny);
        }
    }

    static void pro() {
        cnt = 0;
        max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visit[i][j] || A[i][j] == 0) continue;
                temp = 0;
                dfs(i, j);
                cnt++;
                max = Math.max(max, temp);
            }
        }

        System.out.println(cnt);
        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
