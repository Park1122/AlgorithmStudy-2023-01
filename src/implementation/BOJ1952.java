package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1952 {
    static int M, N;
    static boolean[][] A;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        A = new boolean[M][N];
    }

    static void pro() {
        int ans = 0; // 방향전환 횟수
        int cnt = 1; // 지나온 칸 수
        int nowX = 0;
        int nowY = 0;
        int d = 0;
        A[nowX][nowY] = true;

        while (true) {
            int nx = nowX + dir[d][0];
            int ny = nowY + dir[d][1];

            // 모든 칸을 다 체크한 경우
            if (cnt == M * N) {
                System.out.println(ans);
                break;
            }

            if (nx >= 0 && ny >= 0 && nx < M && ny < N && !A[nx][ny]) {
                cnt++;
                A[nx][ny] = true;
                nowX = nx;
                nowY = ny;
            } else {
                // 방향 전환
                d = (d + 1) % 4;
                ans++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
