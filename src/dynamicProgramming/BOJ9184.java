package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9184 {
    static int A, B, C;
    static int[][][] Dy = new int[21][21][21];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        if(A == -1 && B == -1 && C == -1) return;
    }

    static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }

        if (Dy[a][b][c] != 0) {
            return Dy[a][b][c];
        }

        if (a < b && b < c) {
            Dy[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
            return Dy[a][b][c];
        }

        Dy[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        return Dy[a][b][c];
    }

    static void pro() {
        int ans = w(A, B, C);
        sb.append("w(").append(A).append(", ").append(B).append(", ").append(C).append(") = ").append(ans).append('\n');
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            input();
            if(A == -1 && B == -1 && C == -1) break;
            pro();
        }
        System.out.println(sb.toString());
    }
}
