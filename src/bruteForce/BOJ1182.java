package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1182 {
    static int N, S, ans;
    static int[] A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        A = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void recFunc(int k, int val) {
        if (k == N + 1) {
            if (val == S) ans++;
        } else {
            recFunc(k + 1, val + A[k]);
            recFunc(k + 1, val);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        recFunc(1, 0);
        if(S == 0) ans--;
        System.out.println(ans);
    }
}
