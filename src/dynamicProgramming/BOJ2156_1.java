package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2156_1 {
    static int N;
    static int[] A;
    static int[][] Dy;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        Dy = new int[N + 1][2];
    }

    static void pro() {
        Dy[1][0] = 0;
        Dy[1][1] = A[1];
        if (N >= 2) {
            Dy[2][0] = A[2];
            Dy[2][1] = A[1] + A[2];
        }

        for (int i = 3; i <= N; i++) {
            Dy[i][0] = Math.max(Dy[i - 2][0] + A[i], Dy[i - 2][1] + A[i]);
            Dy[i][0] = Math.max(Dy[i][0], Math.max(Dy[i - 3][0], Dy[i - 3][1]) + A[i]);
            Dy[i][1] = Dy[i - 1][0] + A[i];
        }

        System.out.println(Math.max(Math.max(Dy[N][0], Dy[N][1]), Math.max(Dy[N - 1][0], Dy[N - 1][1])));
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
