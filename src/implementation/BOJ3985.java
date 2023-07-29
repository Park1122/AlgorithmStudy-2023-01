package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3985 {
    static int L, N, wantedMaxIdx;
    static int[] A;
    static int[][] B;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        L = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        A = new int[L + 1];
        B = new int[N + 1][2];
        wantedMaxIdx = 0;
        int max = 0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            B[i][0] = Integer.parseInt(st.nextToken());
            B[i][1] = Integer.parseInt(st.nextToken());
            int l = B[i][1] - B[i][0] + 1;
            if (l > max) {
                wantedMaxIdx = i;
                max = l;
            }
        }
    }

    static void pro() {
        for (int i = 1; i <= N; i++) {
            int p = B[i][0];
            int k = B[i][1];

            for (int j = p; j <= k; j++) {
                if(A[j] != 0) continue;
                A[j] = i;
            }
        }

        int ans = 0;
        int temp = 0;
        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            for (int j = 1; j <= L; j++) {
                if (A[j] == i) {
                    cnt++;
                }
            }

            if (cnt > temp) {
                temp = cnt;
                ans = i;
            }
        }

        System.out.println(wantedMaxIdx);
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
