package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15649 {
    static int N, M;
    static int[] selected, used;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M + 1];
        used = new int[N + 1];
    }

    // N개의 숫자 중에서 중복없이 M개의 수를 순서대로 나열
    // 즉, 순열의 경우의 수(nPm)
    static void recFunc(int k) {
        if (k == M + 1) {
            for(int i=1; i<=M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        } else {
            for (int c = 1; c <= N; c++) {
                if(used[c] == 1) continue;
                selected[k] = c;
                used[c] = 1;

                recFunc(k + 1);

                selected[k] = 0;
                used[c] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        recFunc(1);
        System.out.println(sb.toString());
    }
}
