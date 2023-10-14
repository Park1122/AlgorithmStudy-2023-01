package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ27433 {
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

    static void pro() {
        System.out.println(facto(N));
    }

    static long facto(int k) {
        if (k == 0) {
            return 1;
        }
        if (k == 1) {
            return 1;
        }

        return k * facto(k - 1);
    }
}
