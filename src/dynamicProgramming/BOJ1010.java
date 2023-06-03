package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1010 {
    static int T;
    static int[][] A;
    static int[][] Dy; // nCr
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        T = Integer.parseInt(br.readLine());
        A = new int[T][2];
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
        }
        Dy = new int[30][30];
    }

    static void pro() {
        for (int i = 0; i < 30; i++) {
            Dy[i][i] = 1;
            Dy[i][0] = 1;
        }

        // nCr = n-1Cr-1 + n-1Cr
        // 뽑냐 안뽑냐의 관점을 이용한 조합 점화식
        for (int i = 2; i < 30; i++) {
            for (int j = 1; j < 30; j++) {
                Dy[i][j] = Dy[i - 1][j - 1] + Dy[i - 1][j];
            }
        }

        for (int[] a : A) {
            sb.append(Dy[a[1]][a[0]]).append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
