package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9086 {
    static int T;
    static String[] A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        T = Integer.parseInt(br.readLine());
        A = new String[T];
        for (int i = 0; i < T; i++) {
            A[i] = br.readLine();
        }
    }

    static void pro() {
        for (String s : A) {
            sb.append(s.charAt(0)).append(s.charAt(s.length() - 1)).append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
