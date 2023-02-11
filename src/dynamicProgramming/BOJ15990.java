package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15990 {
    static long[][] Dy;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void preprocess() {
        Dy = new long[100_001][4];
        Dy[1][1] = 1;
        Dy[1][2] = 0;
        Dy[1][3] = 0;
        Dy[2][1] = 0;
        Dy[2][2] = 1;
        Dy[2][3] = 0;
        Dy[3][1] = 1;
        Dy[3][2] = 1;
        Dy[3][3] = 1;

        for (int i = 4; i <= 100_000; i++) {
            Dy[i][1] = (Dy[i - 1][2] + Dy[i - 1][3]) % 1_000_000_009;
            Dy[i][2] = (Dy[i - 2][1] + Dy[i - 2][3]) % 1_000_000_009;
            Dy[i][3] = (Dy[i - 3][1] + Dy[i - 3][2]) % 1_000_000_009;
        }
    }

    static void pro() throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append((Dy[N][1] + Dy[N][2] + Dy[N][3]) % 1_000_000_009).append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        preprocess();
        pro();
    }
}
