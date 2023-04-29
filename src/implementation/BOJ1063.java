package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1063 {
    static String K, S;
    static int N;
    static String[] moving;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        K = st.nextToken();
        S = st.nextToken();
        N = Integer.parseInt(st.nextToken());
        moving = new String[N];
        for (int i = 0; i < N; i++) {
            moving[i] = br.readLine();
        }
    }

    static void pro() {
        // 체스판 세팅
        int Kx = K.charAt(1) - '1';
        int Ky = K.charAt(0) - 'A';
        int Sx = S.charAt(1) - '1';
        int Sy = S.charAt(0) - 'A';

        // 이동 시작
        for (int i = 0; i < N; i++) {
            String str = moving[i];
            int dx = 0;
            int dy = 0;
            switch (str) {
                case "R":
                    dx = 0; dy = 1;
                    break;
                case "L":
                    dx = 0; dy = -1;
                    break;
                case "B":
                    dx = -1; dy = 0;
                    break;
                case "T":
                    dx = 1; dy = 0;
                    break;
                case "RT":
                    dx = 1; dy = 1;
                    break;
                case "LT":
                    dx = 1; dy = -1;
                    break;
                case "RB":
                    dx = -1; dy = 1;
                    break;
                case "LB":
                    dx = -1; dy = -1;
                    break;
            }

            // 킹 이동
            Kx += dx;
            Ky += dy;
            // 킹이 이탈시 복구
            if (Kx < 0 || Ky < 0 || Kx >= 8 || Ky >= 8) {
                Kx -= dx;
                Ky -= dy;
                continue;
            }
            // 킹과 돌이 충돌한 경우, 돌 이동
            if (Kx == Sx && Ky == Sy) {
                Sx += dx;
                Sy += dy;
            }
            // 돌이 이탈한 경우, 킹과 돌 모두 복구
            if (Sx < 0 || Sy < 0 || Sx >= 8 || Sy >= 8) {
                Kx -= dx;
                Ky -= dy;
                Sx -= dx;
                Sy -= dy;
            }
        }

        // 출력
        char KxC = (char) (Kx + '1');
        char KyC = (char) (Ky + 'A');
        char SxC = (char) (Sx + '1');
        char SyC = (char) (Sy + 'A');
        sb.append(KyC).append(KxC).append('\n');
        sb.append(SyC).append(SxC);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
