package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ10431 {
    static int[] A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        A = new int[20];
        st = new StringTokenizer(br.readLine());
        sb.append(Integer.parseInt(st.nextToken())).append(' ');
        for (int i = 0; i < 20; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {
        int ans = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] < A[j]) {
                    ans++;
                }
            }
        }
        sb.append(ans).append('\n');
    }

    public static void main(String[] args) throws IOException {
        int P = Integer.parseInt(br.readLine());
        while (P-- > 0) {
            input();
            pro();
        }
        System.out.println(sb.toString());
    }
}
