package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1987 {
    static int N, M, ans;
    static int[][] A;
    static boolean[] visit;
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
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                A[i][j] = temp.charAt(j) - 'A';
            }
        }
        visit = new boolean[26];
    }

    static void dfs(int x, int y, int k) {
        visit[A[x][y]] = true;
        ans = Math.max(ans, k);

        for (int d = 0; d < 4; d++) {
            int nx = x + dir[d][0];
            int ny = y + dir[d][1];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(visit[A[nx][ny]]) continue;

            dfs(nx, ny, k + 1);
        }

        visit[A[x][y]] = false;
    }

    static void pro() {
        dfs(0, 0, 1);
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
