package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ4134 {
    static long N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Long.parseLong(br.readLine());
    }

    static void pro() {
        BigInteger num = new BigInteger(String.valueOf(N));
        if (num.isProbablePrime(10)) {
            sb.append(num);
        } else {
            sb.append(num.nextProbablePrime());
        }
        sb.append('\n');
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input();
            pro();
        }
        System.out.println(sb.toString());
    }
}
