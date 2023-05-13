package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2525 {
    static int A, B, C;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(br.readLine());
    }

    static void pro() {
        int cHour = C / 60;
        int cMin = C % 60;

        int H = (A + cHour) % 24;
        int M = B + cMin;

        if (M >= 60) {
            H += M / 60;
            M %= 60;
        }
        H %= 24;

        System.out.println(H + " " + M);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
