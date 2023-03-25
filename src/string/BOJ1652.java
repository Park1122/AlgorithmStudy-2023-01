package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1652 {
    static int N;
    static char[][] A;
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

    static void pro() {
        int ans1 = 0, ans2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] == '.') { // A[i][j]는 빈칸
                    // 가로 확인
                    // A[i][j+1]도 빈칸인지 확인(다음칸 확인)
                    if (j + 1 < N && A[i][j + 1] == '.') {
                        // 누운 방향으로 짐 혹은 벽이 존재해야 함
                        // 1. 그 다음다음이 벽인 경우
                        // 2. 그 다음다음이 짐인 경우
                        if (j + 2 >= N || (j + 2 < N && A[i][j + 2] == 'X')) {
                            ans1++;
                        }
                    }
                    // 세로 확인
                    // A[i+1][j]도 빈칸인지 확인(다음칸 확인)
                    if (i + 1 < N && A[i + 1][j] == '.') {
                        // 누운 방향으로 짐 혹은 벽이 존재해야 함
                        // 1. 그 다음다음이 벽인 경우
                        // 2. 그 다음다음이 짐인 경우
                        if (i + 2 >= N || (i + 2 < N && A[i + 2][j] == 'X')) {
                            ans2++;
                        }
                    }
                }
            }
        }

        System.out.println(ans1 + " " + ans2);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
