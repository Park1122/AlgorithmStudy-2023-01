package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3003 {
    static int[] A, criteria;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        A = new int[6];
        for (int i = 0; i < 6; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        criteria = new int[]{1, 1, 2, 2, 2, 8};
    }

    static void pro() {
        for (int i = 0; i < 6; i++) {
            sb.append(criteria[i] - A[i]).append(' ');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
