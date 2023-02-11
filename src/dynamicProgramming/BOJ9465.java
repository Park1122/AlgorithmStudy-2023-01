package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9465 {
    static int N;
    static int[][] A, Dy;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1][2];
        Dy = new int[N + 1][2];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[j][i] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void pro() {
        Dy[1][0] = A[1][0];
        Dy[1][1] = A[1][1];

        for (int i = 2; i <= N; i++) {
            Dy[i][0] = Math.max(Dy[i - 1][1], Dy[i - 2][1]) + A[i][0];
            Dy[i][1] = Math.max(Dy[i - 1][0], Dy[i - 2][0]) + A[i][1];
        }

        sb.append(Math.max(Dy[N][0], Dy[N][1])).append('\n');
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input();
            pro();
        }
        System.out.println(sb.toString());
    }
}
