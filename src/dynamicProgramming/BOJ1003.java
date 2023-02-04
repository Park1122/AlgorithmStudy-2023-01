package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1003 {
    static int T;
    static long[][] Dy;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        T = Integer.parseInt(br.readLine());
    }

    static void preprocess() {
        Dy[0][0] = 1;
        Dy[1][1] = 1;
        for (int i = 2; i <= 40; i++) {
            Dy[i][0] = Dy[i - 1][0] + Dy[i - 2][0];
            Dy[i][1] = Dy[i - 1][1] + Dy[i - 2][1];
        }
    }

    static void pro() throws IOException {
        Dy = new long[41][2];
        preprocess();

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(Dy[n][0]).append(' ').append(Dy[n][1]).append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
