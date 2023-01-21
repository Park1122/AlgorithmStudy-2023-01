package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2667 {
    static int N, cnt;
    static String[] A;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static ArrayList<Integer> groups;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N][N];
        A = new String[N];
        for (int i = 0; i < N; i++) {
            A[i] = br.readLine();
        }
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;
        cnt++;

        for (int d = 0; d < 4; d++) {
            int nx = x + dir[d][0];
            int ny = y + dir[d][1];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(A[nx].charAt(ny) == '0') continue;
            if(visit[nx][ny]) continue;

            dfs(nx, ny);
        }
    }

    static void pro() {
        groups = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] & A[i].charAt(j) == '1') {
                    cnt = 0;
                    dfs(i, j);
                    groups.add(cnt);
                }
            }
        }

        Collections.sort(groups);
        sb.append(groups.size()).append('\n');
        for (int i : groups) {
            sb.append(i).append('\n');
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
