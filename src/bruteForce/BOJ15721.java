package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15721 {
    static int A, T, G, bbeon, daegi ,ans;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        A = Integer.parseInt(br.readLine());
        T = Integer.parseInt(br.readLine());
        G = Integer.parseInt(br.readLine());
        bbeon = 0;
        daegi = 0;
        ans = 0;
    }

    static void pro() {
        int cnt = 2;
        while (true) {
            for (int i = 0; i < 4; i++) { // 뻔 데기 뻔 데기
                if (i % 2 == 0) {
                    bbeon++;
                } else {
                    daegi++;
                }

                if (bbeon == T && G == 0) {
                    ans = (bbeon + daegi - 1) % A;
                    return;
                }
                if (daegi == T && G == 1) {
                    ans = (bbeon + daegi - 1) % A;
                    return;
                }
            }

            // n >= 2
            // 뻔 * n회
            for (int i = 0; i < cnt; i++) {
                bbeon++;
                if (bbeon == T && G == 0) {
                    ans = (bbeon + daegi - 1) % A;
                    return;
                }
            }
            // 데기 * n회
            for (int i = 0; i < cnt; i++) {
                daegi++;
                if (daegi == T && G == 1) {
                    ans = (bbeon + daegi - 1) % A;
                    return;
                }
            }
            cnt++;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
        System.out.println(ans);
    }
}
