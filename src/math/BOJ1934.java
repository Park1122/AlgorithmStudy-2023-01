package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1934 {
    static int A, B;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    static void pro() {
        // 유클리드 호제법 사용
        // gcd(a, b) = gcd(b, r)
        // r:= a%b
        int d = gcd(A, B); // 최대공약수 구하기
        // 최소공배수 := A * B / 최대공약수
        sb.append(A * B / d).append('\n');
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
