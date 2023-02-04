package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10870 {
    static int N;
    static int[] Dy;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

    static void pro() {
        Dy = new int[21];
        Dy[0] = 0;
        Dy[1] = 1;
        for (int i = 2; i <= 20; i++) {
            Dy[i] = Dy[i - 1] + Dy[i - 2];
        }

        System.out.println(Dy[N]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
