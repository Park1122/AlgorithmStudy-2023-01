package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11726 {
    static int N;
    static int[] Dy;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        Dy = new int[N + 1];
    }

    static void pro() {
        Dy[1] = 1;
        Dy[2] = 2;

        for (int i = 3; i <= N; i++) {
            Dy[i] = (Dy[i - 1] + Dy[i - 2]) % 10007;
        }

        System.out.println(Dy[N]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
