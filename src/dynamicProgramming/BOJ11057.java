package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11057 {
    static int N;
    static int[][] Dy;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        Dy = new int[N + 1][10];
    }

    static void pro() {
        for (int i = 0; i < 10; i++) {
            Dy[1][i] = 1;
        }

        for (int len = 2; len <= N; len++) {
            for (int i = 0; i < 10; i++) {
                //Dy[len][i] 계산
                for (int prev = 0; prev <= i; prev++) {
                    Dy[len][i] += Dy[len - 1][prev];
                    Dy[len][i] %= 10007;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += Dy[N][i];
            ans %= 10007;
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
