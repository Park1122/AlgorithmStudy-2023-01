package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1051 {
    static int N, M;
    static String[] A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new String[N];
        for (int i = 0; i < N; i++) {
            A[i] = br.readLine();
        }
    }

    // 4개의 꼭지점이 범위 안에 있는지 확인
    static boolean isRange(int x, int y, int L) {
        int nx = x + L - 1;
        int ny = y + L - 1;

        if(x < 0 || y < 0 || x >= N || y >= M) return false;
        if(nx < 0 || y < 0 || nx >= N || y >= M) return false;
        if(x < 0 || ny < 0 || x >= N || ny >= M) return false;
        if(nx < 0 || ny < 0 || nx >= N || ny >= M) return false;
        return true;
    }

    // 정사각형 꼭지점의 값이 모두 일치하는지 확인
    static boolean isSquare(int x, int y, int L) {
        int nx = x + L - 1;
        int ny = y + L - 1;
        if(A[x].charAt(y) == A[nx].charAt(y) && A[nx].charAt(y) == A[nx].charAt(ny)
                && A[nx].charAt(ny) == A[x].charAt(ny)) return true;
        return false;
    }

    static void pro() {
        int max = Math.max(N, M);
        int ans = 0;
        // 길이가 1부터 탐색
        for (int L = 1; L <= max; L++) {
            for (int i = 0; i < N; i++) {
                boolean flag = false;
                for (int j = 0; j < M; j++) {
                    if(!isRange(i, j, L)) continue;

                    if (isSquare(i, j, L)) {
                        flag = true;
                        ans = L;
                        break;
                    }
                }
                if(flag) break;
            }
        }

        System.out.println(ans * ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
