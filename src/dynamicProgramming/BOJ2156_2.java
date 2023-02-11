package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2156_2 {
    static int N;
    static int[] A, Dy;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        Dy = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
    }

    static void pro() {
        Dy[1] = A[1];
        if (N >= 2) {
            Dy[2] = A[1] + A[2];
        }

        for (int i = 3; i <= N; i++) {
            Dy[i] = Math.max(Dy[i - 1], Math.max(Dy[i - 2] + A[i], Dy[i - 3] + A[i - 1] + A[i]));
        }

        System.out.println(Dy[N]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
