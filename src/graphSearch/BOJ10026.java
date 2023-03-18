package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ10026 {
    static int N;
    static char[][] A;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new char[N][N];
        for (int i = 0; i < N; i++) {
            A[i] = br.readLine().toCharArray();
        }
        visit = new boolean[N][N];
    }

    static void bfs(int sx, int sy) {
        Queue<Integer> q = new LinkedList<>();
        q.add(sx);
        q.add(sy);
        visit[sx][sy] = true;

        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            int currentColor = A[x][y];

            for (int d = 0; d < 4; d++) {
                int nx = x + dir[d][0];
                int ny = y + dir[d][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visit[nx][ny]) continue;
                if(currentColor != A[nx][ny]) continue;

                q.add(nx);
                q.add(ny);
                visit[nx][ny] = true;
            }
        }
    }

    static void pro() {
        // 색약이 아닌 경우
        int ans1 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(visit[i][j]) continue;
                bfs(i, j);
                ans1++;
            }
        }
        // 색약인 경우
        visit = new boolean[N][N];
        int ans2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(A[i][j] == 'G') A[i][j] = 'R';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(visit[i][j]) continue;
                bfs(i, j);
                ans2++;
            }
        }

        System.out.println(ans1 + " " + ans2);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
