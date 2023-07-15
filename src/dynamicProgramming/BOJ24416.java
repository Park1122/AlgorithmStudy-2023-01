package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ24416 {
    static int N, cnt1, cnt2;
    static int[] Dy;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        Dy = new int[N + 1];
    }

    static int fib(int n) {
        if (n == 1 || n == 2) {
            cnt1++;
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    static int fibonacci(int n) {
        Dy[1] = 1;
        Dy[2] = 1;
        for (int i = 3; i <= n; i++) {
            cnt2++;
            Dy[i] = Dy[i - 1] + Dy[i - 2];
        }
        return Dy[n];
    }

    static void pro() {
        fib(N);
        fibonacci(N);

        System.out.println(cnt1 + " " + cnt2);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
