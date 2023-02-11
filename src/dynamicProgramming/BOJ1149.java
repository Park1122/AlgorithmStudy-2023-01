package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149 {
    static int N;
    static int[] A;
    static int[][] Dy;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[3];
        Dy = new int[N + 1][3];
    }

    static void pro() throws IOException {
        // Dy[i][j] := i-1번째까지 색칠 후, i번째에 j번째 색으로 칠하는 경우 중 최소 비용
        Dy[0][0] = Dy[0][1] = Dy[0][2] = 0;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }

            Dy[i][0] = Math.min(Dy[i - 1][1], Dy[i - 1][2]) + A[0];
            Dy[i][1] = Math.min(Dy[i - 1][0], Dy[i - 1][2]) + A[1];
            Dy[i][2] = Math.min(Dy[i - 1][0], Dy[i - 1][1]) + A[2];
        }

        System.out.println(Math.min(Dy[N][0], Math.min(Dy[N][1], Dy[N][2])));
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
