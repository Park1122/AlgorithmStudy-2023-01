package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1769 {
    static String A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        A = br.readLine();
    }

    static void pro() {
        int step = 0;
        while (A.length() != 1) {
            step++;
            int sum = 0;
            for (int i = 0; i < A.length(); i++) {
                int n = A.charAt(i) - '0';
                sum += n;
            }
            A = String.valueOf(sum);
        }

        System.out.println(step);
        if ("3".equals(A) || "6".equals(A) || "9".equals(A)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
