package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18111 {
    static int N, M, B, min, max;
    static int[][] A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        min = 256;
        max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, A[i][j]);
                max = Math.max(max, A[i][j]);
            }
        }
    }

    static void pro() {
        int height = 0;
        int time = Integer.MAX_VALUE;

        for (int h = min; h <= max; h++) {
            int cnt = 0;
            int block = B;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (h < A[i][j]) {
                        cnt += (A[i][j] - h) * 2;
                        block += A[i][j] - h;
                    } else if (h > A[i][j]) {
                        cnt += h - A[i][j];
                        block -= h - A[i][j];
                    }
                }
            }

            if(block < 0) continue;
            if (time >= cnt) {
                time = cnt;
                height = h;
            }
        }

        System.out.println(time + " " + height);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
