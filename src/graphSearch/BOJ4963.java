package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4963 {
    static int W, H, ans;
    static int[][] map;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        if(W == 0 && H == 0) return;
        map = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit = new boolean[H][W];
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int d = 0; d < 8; d++) {
            int nx = x + dir[d][0];
            int ny = y + dir[d][1];
            if(nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
            if(map[nx][ny] == 0) continue;
            if(visit[nx][ny]) continue;
            dfs(nx, ny);
        }
    }

    static void pro() {
        ans = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(visit[i][j] || map[i][j] == 0) continue;
                dfs(i, j);
                ans++;
            }
        }
        sb.append(ans).append('\n');
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            input();
            if(W == 0 && H == 0) break;
            pro();
        }
        System.out.println(sb.toString());
    }
}
