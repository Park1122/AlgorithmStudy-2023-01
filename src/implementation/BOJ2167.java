package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2167 {
    static int N, M, T;
    static int[][] A, arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        T = Integer.parseInt(br.readLine());
        arr = new int[T][4];
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void pro() {
        for (int t = 0; t < T; t++) {
            int sum = 0;
            for (int i = arr[t][0] - 1; i <= arr[t][2] - 1; i++) {
                for (int j = arr[t][1] - 1; j <= arr[t][3] - 1; j++) {
                    sum += A[i][j];
                }
            }
            sb.append(sum).append('\n');
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
