package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ10826 {
    static int N;
    static BigInteger[] Dy;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        Dy = new BigInteger[10_001];
    }

    static void pro() {
        Dy[0] = BigInteger.ZERO;
        Dy[1] = BigInteger.ONE;
        for (int i = 2; i <= 10_000; i++) {
            Dy[i] = Dy[i - 1].add(Dy[i - 2]);
        }

        System.out.println(Dy[N]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
