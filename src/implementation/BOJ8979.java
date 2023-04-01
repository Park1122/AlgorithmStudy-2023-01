package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ8979 {
    static int N, K;
    static int[][] A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N][4];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void pro() {
        Arrays.sort(A, (a, b) -> {
            if(a[1] != b[1]) return b[1] - a[1];
            if(a[2] != b[2]) return b[2] - a[2];
            return b[3] - a[3];
        });

        if (A[0][0] == K) {
            System.out.println(1);
            return;
        }

        int rank = 1;
        int cnt = 1;
        for (int i = 1; i < N; i++) {
            if (A[i - 1][1] != A[i][1] || A[i - 1][2] != A[i][2] || A[i - 1][3] != A[i][3]) {
                rank += cnt;
                cnt = 1;
            }else {
                cnt++;
            }

            if (A[i][0] == K) {
                break;
            }
        }

        System.out.println(rank);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
