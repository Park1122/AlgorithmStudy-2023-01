package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1037 {
    static int N;
    static int[] A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {
        if (N == 1) {
            System.out.println(A[0] * A[0]);
        } else {
            Arrays.sort(A);
            System.out.println(A[0] * A[N - 1]);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
