package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2193 {
    static int N;
    static long[][] Dy;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

    static void pro() {
        Dy = new long[N + 1][2];
        Dy[1][1] = 1;
        for (int i = 2; i <= N; i++) {
            Dy[i][0] = Dy[i - 1][0] + Dy[i - 1][1];
            Dy[i][1] = Dy[i - 1][0];
        }

        System.out.println(Dy[N][0] + Dy[N][1]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
