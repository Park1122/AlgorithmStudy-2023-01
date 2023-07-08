package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9506 {
    static int N;
    static boolean[] A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        if (N == -1) {
            return;
        }
        A = new boolean[N + 1];
    }

    static void pro() {
        int sum = 0;
        for (int i = 1; i < N; i++) {
            if (N % i == 0) {
                A[i] = true;
                sum += i;
            }
        }

        if (sum != N) {
            System.out.println(N + " is NOT perfect.");
            return;
        }

        sb.append(N).append(" = ");
        for (int i = 1; i < N; i++) {
            if (A[i]) {
                sb.append(i).append(" + ");
            }
        }
        System.out.println(sb.substring(0, sb.length() - 2));
        sb.setLength(0);
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            input();
            if(N == -1) return;
            pro();
        }
    }
}
