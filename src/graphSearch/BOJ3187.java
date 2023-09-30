package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3187 {
    static int R, C, cntSheep, cntWolf;
    static char[][] A;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        A = new char[R][C];
        visit = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            A[i] = br.readLine().toCharArray();
        }
    }

    static void pro() {
        int totalSheep = 0;
        int totalWolf = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] == 'v') {
                    totalWolf++;
                } else if (A[i][j] == 'k') {
                    totalSheep++;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(visit[i][j]) continue;
                if(A[i][j] == '#') continue;
                cntSheep = 0;
                cntWolf = 0;
                dfs(i, j);
                if (cntSheep > cntWolf) {
                    totalWolf -= cntWolf;
                } else {
                    totalSheep -= cntSheep;
                }
            }
        }

        System.out.println(totalSheep + " " + totalWolf);
    }

    static void dfs(int x, int y) {
        if (A[x][y] == 'v') {
            cntWolf++;
        } else if (A[x][y] == 'k') {
            cntSheep++;
        }
        visit[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dir[d][0];
            int ny = y + dir[d][1];

            if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            if(visit[nx][ny]) continue;
            if(A[nx][ny] == '#') continue;

            dfs(nx, ny);
        }
    }
}
