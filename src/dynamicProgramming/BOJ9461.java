package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9461 {
    static int T;
    static int[] A;
    static long[] Dy;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        T = Integer.parseInt(br.readLine());
        A = new int[T];
        for (int i = 0; i < T; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        Dy = new long[101];
    }

    static void pro() {
        Dy[1] = 1;
        Dy[2] = 1;
        Dy[3] = 1;
        for (int i = 4; i <= 100; i++) {
            Dy[i] = Dy[i - 2] + Dy[i - 3];
        }

        for (int i : A) {
            sb.append(Dy[i]).append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
