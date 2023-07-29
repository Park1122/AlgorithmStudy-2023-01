package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1547 {
    static int M;
    static int[][] C;
    static int[] A; // A[i] := i번 컵이 현재 있는 위치
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        M = Integer.parseInt(br.readLine());
        C = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            C[i][0] = Integer.parseInt(st.nextToken());
            C[i][1] = Integer.parseInt(st.nextToken());
        }
        A = new int[]{0, 1, 2, 3};
    }

    static void pro() {
        for (int i = 0; i < M; i++) {
            int x = C[i][0];
            int y = C[i][1];
            if(x == y) continue;

            int temp = A[x];
            A[x] = A[y];
            A[y] = temp;
        }

        for (int i = 1; i <= 3; i++) {
            if (A[i] == 1) {
                System.out.println(i);
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
