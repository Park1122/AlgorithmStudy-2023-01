package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10819 {
    static int N, ans;
    static int[] A, selected;
    static boolean[] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        visited = new boolean[N + 1];
        selected = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        ans = Integer.MIN_VALUE;
    }

    static void calc() {
        int res = 0;
        for (int i = 1; i < N; i++) {
            res += Math.abs(A[selected[i]] - A[selected[i + 1]]);
        }
        ans = Math.max(ans, res);
    }

    static void recFunc(int k) {
        if (k == N + 1) {
            calc();
        } else {
            for (int cand = 1; cand <= N; cand++) {
                // 순열
                if(visited[cand]) continue;
                selected[k] = cand;
                visited[cand] = true;
                recFunc(k + 1);
                selected[k] = 0;
                visited[cand] = false;
            }
        }
    }

    static void pro() {
        recFunc(1);
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
