package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9655 {
    static int N;
    static int[] Dy; // 짝수면 창영이 승리, 홀수면 상근이 승리
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        Dy = new int[1001];
    }

    static void pro() {
        Dy[1] = 1;
        Dy[2] = 2;
        Dy[3] = 1;
        for (int i = 4; i <= 1000; i++) {
            Dy[i] = Math.min(Dy[i - 1], Dy[i - 3]) + 1;
        }

        if (Dy[N] % 2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
