package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ5555 {
    static String line;
    static String[] A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void input() throws IOException {
        line = br.readLine();
        int T = Integer.parseInt(br.readLine());
        A = new String[T];
        for (int i = 0; i < T; i++) {
            A[i] = br.readLine();
        }
    }

    static void pro() {
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            String str = A[i];
            str += str;
            if (str.contains(line)) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
