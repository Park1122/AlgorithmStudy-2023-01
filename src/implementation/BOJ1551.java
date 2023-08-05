package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1551 {
    static int N, K;
    static int[] A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N];
        st = new StringTokenizer(br.readLine(), ",");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {
        int l = N;
        while (K-- > 0) {
            int[] temp = new int[l - 1];
            for (int i = 1; i < l; i++) {
                temp[i - 1] = A[i] - A[i - 1];
            }
            l--;
            A = temp;
        }

        for (int i = 0; i < A.length; i++) {
            if (i == A.length - 1) {
                sb.append(A[i]);
            } else {
                sb.append(A[i]).append(',');
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
