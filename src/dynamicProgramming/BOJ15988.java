package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15988 {
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
        Dy[3] = 4;
        for (int i = 4; i <= 1_000_000; i++) {
            Dy[i] = (Dy[i - 1] + Dy[i - 2] + Dy[i - 3]) % 1_000_000_009;
        }
    }

    static void pro() throws IOException {
        Dy = new long[1_000_001];
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
