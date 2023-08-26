package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16395 {
    static int N, K;
    static int[][] Dy;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Dy = new int[31][31];
    }

    static void pro() {
        Dy[1][1] = 1;
        Dy[2][1] = 1;
        Dy[2][2] = 1;

        for (int i = 3; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                Dy[i][j] = Dy[i - 1][j - 1] + Dy[i - 1][j];
            }
        }

        System.out.println(Dy[N][K]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
