package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ25304 {
    static int X, N;
    static int[][] A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        X = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        A = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int a = A[i][0];
            int b = A[i][1];
            ans += a * b;
        }

        if (ans == X) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
