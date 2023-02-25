package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ25305 {
    static int N, K;
    static int[] scores;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        scores = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {
        Arrays.sort(scores);
        int idx = 0;
        for (int i = scores.length - 1; i >= 0; i--) {
            idx++;
            if (idx == K) {
                System.out.println(scores[i]);
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
