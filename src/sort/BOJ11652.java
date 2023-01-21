package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11652 {
    static int N;
    static long[] A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Long.parseLong(br.readLine());
        }
    }

    static void pro() {
        Arrays.sort(A, 1, N + 1);

        long val = A[1]; // 최빈값
        int valCnt = 1; // 최빈값 등장 횟수
        int currentCnt = 1; // 최신값의 등장 횟수
        for (int i = 2; i <= N; i++) {
            if (A[i - 1] == A[i]) {
                currentCnt++;
            } else {
                currentCnt = 1;
            }

            if (currentCnt > valCnt) {
                valCnt = currentCnt;
                val = A[i];
            }
        }

        System.out.println(val);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
