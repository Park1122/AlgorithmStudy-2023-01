package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9663 {
    static int N, ans;
    static int[] col;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        col = new int[N + 1];
        ans = 0;
    }

    static boolean isAttackable(int r1, int c1, int r2, int c2) {
        if(c1 == c2) return true;
        if(r1 - c1 == r2 - c2) return true;
        if(r1 + c1 == r2 + c2) return true;
        return false;
    }

    static void recFunc(int k) {
        if (k == N + 1) {
            ans++;
        } else {
            for (int cand = 1; cand <= N; cand++) {
                boolean possible = true;
                for (int i = 1; i <= k - 1; i++) {
                    if (isAttackable(k, cand, i, col[i])) {
                        possible = false;
                        break;
                    }
                }

                if (possible) {
                    col[k] = cand;
                    recFunc(k + 1);
                    col[k] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        recFunc(1);
        System.out.println(ans);
    }
}
