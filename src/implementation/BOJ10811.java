package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10811 {
    static int N, M;
    static int[] A;
    static int[][] methods;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = i + 1;
        }
        methods = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            methods[i][0] = Integer.parseInt(st.nextToken());
            methods[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {
        for (int i = 0; i < M; i++) {
            int x = methods[i][0] - 1;
            int y = methods[i][1] - 1;

            while (x < y) {
                int temp = A[x];
                A[x] = A[y];
                A[y] = temp;
                x++;
                y--;
            }
        }

        for (int i : A) {
            sb.append(i).append(' ');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
