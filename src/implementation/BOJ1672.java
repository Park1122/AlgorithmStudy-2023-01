package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1672 {
    static int N;
    static String str;
    static int[][] M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        str = br.readLine();
    }

    static void pro() {
        char before = ' ';
        char after = str.charAt(str.length() - 1);

        for (int i = N - 1; i >= 0; i--) {
            before = str.charAt(i);
            after = decode(before, after);
        }

        System.out.println(after);
    }

    static char decode(char A, char B) {
        char res;

        if (A == 'A') {
            if (B == 'A') {
                res = 'A';
            } else if (B == 'G') {
                res = 'C';
            } else if (B == 'C') {
                res = 'A';
            } else {
                res = 'G';
            }
        } else if (A == 'G') {
            if (B == 'A') {
                res = 'C';
            } else if (B == 'G') {
                res = 'G';
            } else if (B == 'C') {
                res = 'T';
            } else {
                res = 'A';
            }
        } else if (A == 'C') {
            if (B == 'A') {
                res = 'A';
            } else if (B == 'G') {
                res = 'T';
            } else if (B == 'C') {
                res = 'C';
            } else {
                res = 'G';
            }
        } else {
            if (B == 'A') {
                res = 'G';
            } else if (B == 'G') {
                res = 'A';
            } else if (B == 'C') {
                res = 'G';
            } else {
                res = 'T';
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
