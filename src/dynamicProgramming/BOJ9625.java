package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9625 {
    static int K;
    static int[][] Dy;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        K = Integer.parseInt(br.readLine());
        Dy = new int[46][2];
    }

    static void pro() {
        Dy[1][0] = 0;
        Dy[1][1] = 1;
        for (int i = 2; i <= K; i++) {
            Dy[i][0] = Dy[i - 1][1];
            Dy[i][1] = Dy[i - 1][0] + Dy[i - 1][1];
        }

        System.out.println(Dy[K][0] + " " + Dy[K][1]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
