package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2563 {
    static int N;
    static int[][] rects;
    static boolean[][] map;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        rects = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            rects[i][0] = x;
            rects[i][1] = y;
        }
        map = new boolean[101][101];
    }

    static void pro() {
        int ans = 0;

        for (int i = 0; i < N; i++) {
            int x = rects[i][0];
            int y = rects[i][1];
            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    if (!map[j][k]) {
                        map[j][k] = true;
                        ans++;
                    }
                }
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
