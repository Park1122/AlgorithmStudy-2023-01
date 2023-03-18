package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3085 {
    static int N, ans;
    static char[][] A; // C빨P파Z초A노
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new char[N][N];
        for (int i = 0; i < N; i++) {
            A[i] = br.readLine().toCharArray();
        }
    }

    static void updateMaxValue() {
        // 가로길이 확인
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N - 1; j++) {
                if (A[i][j] == A[i][j + 1]) {
                    cnt++;
                } else {
                    cnt = 1;
                }

                ans = Math.max(ans, cnt);
            }
        }

        // 세로길이 확인
        for (int j = 0; j < N; j++) {
            int cnt = 1;
            for (int i = 0; i < N - 1; i++) {
                if (A[i][j] == A[i + 1][j]) {
                    cnt++;
                } else {
                    cnt = 1;
                }

                ans = Math.max(ans, cnt);
            }
        }
    }

    static void pro() {
        // 행에서 바꾸기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                // 교환
                char temp = A[i][j];
                A[i][j] = A[i][j + 1];
                A[i][j + 1] = temp;
                // 길이 갱신
                updateMaxValue();
                // 복구
                temp = A[i][j];
                A[i][j] = A[i][j + 1];
                A[i][j + 1] = temp;
            }
        }

        // 열에서 바꾸기
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N - 1; i++) {
                // 교환
                char temp = A[i][j];
                A[i][j] = A[i + 1][j];
                A[i + 1][j] = temp;
                // 길이 갱신
                updateMaxValue();
                // 복구
                temp = A[i][j];
                A[i][j] = A[i + 1][j];
                A[i + 1][j] = temp;
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
