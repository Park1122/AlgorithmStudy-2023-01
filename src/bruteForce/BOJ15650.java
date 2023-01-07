package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15650 {
    static int N, M;
    static int[] selected;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M + 1];
    }

    // N개의 숫자 중에서 중복없이 M개의 수를 순서없이 뽑기
    // 즉, 조합의 경우의 수(nCm)
    static void recFunc(int k) {
        if (k == M + 1) {
            for(int i=1; i<=M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        } else {
            for (int c = selected[k - 1] + 1; c <= N; c++) {
                selected[k] = c;
                recFunc(k + 1);
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        recFunc(1);
        System.out.println(sb.toString());
    }
}
