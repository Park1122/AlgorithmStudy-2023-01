package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15991 {
    static int T;
    static long[] Dy;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        T = Integer.parseInt(br.readLine());
    }

    static void preprocess() {
        Dy[1] = 1;
        Dy[2] = 2;
        Dy[3] = 2;
        Dy[4] = 3;
        Dy[5] = 3;
        Dy[6] = 6;
        // 1 + 대칭인 수 + 1 -> i - 2
        // 2 + 대칭인 수 + 2 -> i - 4
        // 3 + 대칭인 수 + 3 -> i - 6
        for (int i = 7; i <= 100_000; i++) {
            Dy[i] = (Dy[i - 2] + Dy[i - 4] + Dy[i - 6]) % 1_000_000_009;
        }
    }

    static void pro() throws IOException {
        Dy = new long[100_001];
        preprocess();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(Dy[N]).append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
