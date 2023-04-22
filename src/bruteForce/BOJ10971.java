package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10971 {
    static int N, ans;
    static int[][] W;
    static boolean[] visit;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        W = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = Integer.MAX_VALUE;
    }

    static boolean isAllVisited() {
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                return false;
            }
        }
        return true;
    }

    static void recFunc(int start, int from, int sum) {
        if (isAllVisited()) {
            if (W[from][start] != 0) {
                sum += W[from][start];
                ans = Math.min(ans, sum);
            }
        } else {
            for (int to = 1; to <= N; to++) {
                if(visit[to]) continue;
                if(W[from][to] == 0) continue;

                visit[to] = true;
                recFunc(start, to, sum + W[from][to]);
                visit[to] = false;
            }
        }
    }

    static void pro() {
        for (int i = 1; i <= N; i++) {
            visit = new boolean[N + 1];
            visit[i] = true;
            recFunc(i, i, 0);
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
