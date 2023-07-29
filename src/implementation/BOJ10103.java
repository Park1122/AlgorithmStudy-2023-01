package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10103 {
    static int N;
    static int[][] A;
    static int Chang = 100, Sang = 100;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {
        for (int i = 0; i < N; i++) {
            if (A[i][0] > A[i][1]) {
                Sang -= A[i][0];
            } else if (A[i][0] < A[i][1]) {
                Chang -= A[i][1];
            }
        }

        sb.append(Chang).append('\n').append(Sang);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
