package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1120 {
    static String A, B;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        A = st.nextToken();
        B = st.nextToken();
    }

    static void pro() {
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= B.length() - A.length(); i++) {
            int cnt = 0;
            for (int j = 0; j < A.length(); j++) {
                if (A.charAt(j) != B.charAt(i + j)) {
                    cnt++;
                }
            }

            ans = Math.min(ans, cnt);
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
