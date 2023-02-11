package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2688 {
    static int N;
    static long[][] Dy;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void preprocess() {
        // Dy[i][j] := i자리 숫자의 1의 자리 숫자가 j가 올 경우
        Dy = new long[65][10];
        for (int i = 1; i <= 64; i++) {
            Dy[i][0] = 1;
            for (int j = 1; j < 10; j++) {
                if (i == 1) {
                    Dy[i][j] = 1;
                } else {
                    Dy[i][j] = Dy[i - 1][j] + Dy[i][j - 1];
                }
            }
        }
    }

    static void pro() throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            long ans = 0;
            for (int i = 0; i < 10; i++) {
                ans += Dy[N][i];
            }

            sb.append(ans).append('\n');
        }
    }

    public static void main(String[] args) throws IOException {
        preprocess();
        pro();
        System.out.println(sb.toString());
    }

}
