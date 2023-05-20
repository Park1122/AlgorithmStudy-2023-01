package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10157 {
    static int C, R, K;
    static int[][] A;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        A = new int[R][C];
    }

    static void pro() {
        if (K > C * R) {
            System.out.println(0);
            return;
        }

        int val = 1;
        int x = R - 1;
        int y = 0;
        int d = 0;
        while (true) {
            // 두기
            A[x][y] = val;
            if (val == K) {
                System.out.println((y + 1) + " " + (R - x));
                break;
            }

            // 다음 단계 준비
            val++;
            x += dir[d][0];
            y += dir[d][1];

            if (x < 0 || y < 0 || x >= R || y >= C || A[x][y] != 0) {
                x -= dir[d][0];
                y -= dir[d][1];
                d = (d + 1) % 4;
                x += dir[d][0];
                y += dir[d][1];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
