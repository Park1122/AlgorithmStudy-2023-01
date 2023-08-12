package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15904 {
    static String A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        A = br.readLine();
    }

    static void pro() {
        char[] arr = A.toCharArray();

        int idx = 0;
        for (char c : arr) {
            if (idx == 0 && c == 'U') {
                idx++;
            }
            if ((idx == 1 || idx == 3) && c == 'C') {
                idx++;
            }
            if (idx == 2 && c == 'P') {
                idx++;
            }
        }

        if (idx == 4) {
            System.out.println("I love UCPC");
        } else {
            System.out.println("I hate UCPC");
        }

    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
