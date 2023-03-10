package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 피보나치 수열 특성을 이용한 문제
 * 1. 피사노 주기 : 피보나치 수를 K로 나눈 나머지는 항상 주기를 갖는다.
 * 2. 주기의 길이가 P이면, N번째 피보나치 수를 M으로 나눈 나머지는 N % P번째 피보나치 수를 M으로 나눈 나머지와 같다.
 * 3. 나누려는 값 M = 10^k일 때, 주기는 항상 15 * 10^(k-1)
 */
public class BOJ2749 {
    static long N;
    static int period;
    static long[] Dy;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Long.parseLong(br.readLine());
        period = 15_000_000;
        Dy = new long[period + 1];
        N %= period;
    }

    static void pro() {
        Dy[0] = 0;
        Dy[1] = 1;
        for (int i = 2; i <= period; i++) {
            Dy[i] = (Dy[i - 1] + Dy[i - 2]) % 1_000_000;
        }

        System.out.println(Dy[(int)N]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
