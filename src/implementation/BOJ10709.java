package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10709 {
    static int H, W;
    static char[][] A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        A = new char[H][W];
        for (int i = 0; i < H; i++) {
            A[i] = br.readLine().toCharArray();
        }
    }

    static void pro() {
        for (int i = 0; i < H; i++) {
            int time = 0;
            for (int j = 0; j < W; j++) {
                // 현재 구름인 경우 -> time 초기화, 0 출력
                if (A[i][j] == 'c') {
                    time = 1;
                    sb.append(0);
                } else if (A[i][j] == '.') {
                    // 구름이 없는 경우 -> 이전에 구름이 있었으면 time, 없었으면 -1 출력
                    if (time == 0) {
                        sb.append(-1);
                    } else {
                        sb.append(time);
                        time++;
                    }
                }
                sb.append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
