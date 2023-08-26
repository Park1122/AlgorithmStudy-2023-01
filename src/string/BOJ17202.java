package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17202 {
    static String A, B;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        A = br.readLine();
        B = br.readLine();
    }

    static void pro() {
        String S = "";
        for (int i = 0; i < A.length(); i++) {
            S += A.charAt(i);
            S += B.charAt(i);
        }

        while (S.length() > 2) {
            String temp = "";
            for (int i = 0; i < S.length() - 1; i++) {
                int n = Character.getNumericValue(S.charAt(i)) + Character.getNumericValue(S.charAt(i + 1));
                temp += Integer.toString(n % 10);
            }
            S = temp;
        }

        System.out.println(S);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
