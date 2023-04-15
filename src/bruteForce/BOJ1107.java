package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1107 {
    static int N, M;
    static boolean[] broken;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        broken = new boolean[10];
        if (M > 0) {
            st = new StringTokenizer(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            broken[Integer.parseInt(st.nextToken())] = true;
        }
    }

    static void pro() {
        int ans = Math.abs(N - 100); // +, - 버튼으로만 이동한 경우

        for (int i = 0; i <= 999999; i++) {
            String num = String.valueOf(i);

            boolean isBroken = false;
            for (int j = 0; j < num.length(); j++) {
                if (broken[num.charAt(j) - '0']) {
                    isBroken = true;
                    break;
                }
            }

            if (!isBroken) {
                int min = num.length() + Math.abs(N - i); // 가장 근접한 수로 이동(버튼 길이만큼 클릭) + +/- 버튼 이동 횟수
                ans = Math.min(ans, min);
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
