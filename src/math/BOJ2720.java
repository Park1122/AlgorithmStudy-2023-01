package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2720 {
    static int N;
    static final int Quarter = 25;
    static final int Dime = 10;
    static final int Nickel = 5;
    static final int Penny = 1;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

    static void pro() {
        sb.append(N / Quarter).append(" ");
        N %= Quarter;
        sb.append(N / Dime).append(" ");
        N %= Dime;
        sb.append(N / Nickel).append(" ");
        N %= Nickel;
        sb.append(N / Penny).append('\n');
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
