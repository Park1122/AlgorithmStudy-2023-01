package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2669 {
    static int[][] A, rects;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        A = new int[101][101];
        rects = new int[4][4];
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                rects[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void pro() {
        // 범위 체크
        for (int r = 0; r < 4; r++) {
            int x1 = rects[r][0];
            int y1 = rects[r][1];
            int x2 = rects[r][2];
            int y2 = rects[r][3];
            for (int i = y1; i < y2; i++) {
                for (int j = x1; j < x2; j++) {
                    A[i][j] = 1;
                }
            }
        }

        // 직사각형 4개 겹치는 면적 체크
        int ans = 0;
        for (int i = 0; i < 101; i++) {
            for (int j = 1; j < 101; j++) {
                if(A[i][j] == 1) ans++;
            }
        }

        System.out.println(ans);
    }
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
