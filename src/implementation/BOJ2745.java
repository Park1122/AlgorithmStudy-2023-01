package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2745 {
    static String N;
    static int B;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = st.nextToken();
        B = Integer.parseInt(st.nextToken());
    }

    static void pro() {
        int i = Integer.parseInt(N, B);
        System.out.println(i);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
