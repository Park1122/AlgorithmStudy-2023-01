package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17626 {
    static int N;
    static int[] Dy; // Dy[i] := i보다 작은 제곱수(j * j) + Dy[i - j*j] => 즉, Dy[i-j*j] + 1 이라는 값을 갖게 됨
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        Dy = new int[50001];
    }

    static void pro() {
        Dy[0] = 0;
        Dy[1] = 1;
        for (int i = 2; i <= N; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, Dy[i - j * j]);
            }
            Dy[i] = min + 1;
        }

        System.out.println(Dy[N]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
