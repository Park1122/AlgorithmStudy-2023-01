package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10844 {
    static int N;
    static long[][] Dy; // Dy[i][j] := i길이의 숫자 중에서, j라는 수로 시작하는 수들 중 계단의 수
    static final long M = 1_000_000_000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        Dy = new long[N + 1][10];
    }

    static void pro() {
        for (int i = 0; i <= 9; i++) {
            Dy[1][i] = 1L;
        }

        for (int i = 2; i <= N; i++) {
            Dy[i][0] = Dy[i - 1][1];
            for (int j = 1; j <= 9; j++) {
                if (j == 9) {
                    // 9일 경우, 이전 자릿수의 8로 시작하는 경우의 수와 동일
                    Dy[i][9] = Dy[i - 1][8] % M;
                } else {
                    // 이전 자릿수의 j-1, j+1로 시작하는 숫자들의 경우의 수의 합과 동일
                    Dy[i][j] = (Dy[i - 1][j - 1] % M + Dy[i - 1][j + 1] % M) % M;
                }
            }
        }

        long ans = 0;
        for (int i = 1; i <= 9; i++) {
            ans = (ans + Dy[N][i]) % M;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
