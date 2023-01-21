package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ20291 {
    static int N;
    static String[] A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new String[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), ".");
            st.nextToken();
            A[i] = st.nextToken();
        }
    }

    static void pro() {
        Arrays.sort(A, 1, N + 1);

        for (int i = 1; i <= N;) {
            int cnt = 1;
            int j;
            for (j = i + 1; j <= N; j++) {
                if(A[i].equals(A[j])) cnt++;
                else break;
            }

            sb.append(A[i]).append(' ').append(cnt).append('\n');
            i=j;
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
