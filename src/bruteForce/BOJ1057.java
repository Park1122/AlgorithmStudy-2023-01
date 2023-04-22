package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1057 {
    static int N, A, B;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
    }

    static void pro() {
        int step = 0;
        while (A != B) {
            step++;
            A = A / 2 + A % 2;
            B = B / 2 + B % 2;
        }

        System.out.println(step);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
