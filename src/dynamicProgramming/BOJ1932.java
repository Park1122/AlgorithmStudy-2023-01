package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1932 {
    static int N;
    static int[][] Dy, A; // Dy[i][j] := (i, j)에 도착했을 때 최댓값
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1][N + 1];
        Dy = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void pro() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                Dy[i][j] = Math.max(Dy[i - 1][j - 1], Dy[i - 1][j]) + A[i][j];
            }
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, Dy[N][i]);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
