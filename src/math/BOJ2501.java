package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2501 {
    static int N, K;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }

    static void pro() {
        int step = 0;
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                step++;
                if (step == K) {
                    System.out.println(i);
                    return;
                }
            }
        }

        if (step < K) {
            System.out.println(0);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
