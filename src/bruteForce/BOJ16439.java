package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16439 {
    static int N, M, ans;
    static int[][] preferences;
    static int[] selected;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        preferences = new int[N + 1][M + 1];
        selected = new int[3 + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                preferences[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    // M개의 치킨 중에서 3개의 치킨을 순서없이, 중복없이 뽑기(조합)
    static void recFunc(int k) {
        if (k == 4) {
            int score = 0;
            for (int i = 1; i <= N; i++) {
                int temp = 0;
                for (int j = 1; j <= 3; j++) {
                    temp = Math.max(temp, preferences[i][selected[j]]);
                }
                score += temp;
            }
            ans = Math.max(score, ans);
        } else {
            for (int cand = selected[k - 1] + 1; cand <= M; cand++) {
                selected[k] = cand;
                recFunc(k + 1);
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        recFunc(1);
        System.out.println(ans);
    }
}
