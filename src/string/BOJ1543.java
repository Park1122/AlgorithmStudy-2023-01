package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1543 {
    static String A, B;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        A = br.readLine();
        B = br.readLine();
    }

    static void pro() {
        int ans = 0;
        for (int i = 0; i <= A.length() - B.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < B.length(); j++) {
                if (A.charAt(i + j) != B.charAt(j)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                ans++;
                i += B.length() - 1;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
