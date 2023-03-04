package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1032 {
    static int N;
    static String[] files;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        files = new String[N];
        for (int i = 0; i < N; i++) {
            files[i] = br.readLine();
        }
    }

    static void pro() {
        for (int i = 0; i < files[0].length(); i++) {
            boolean isSame = true;
            char c = files[0].charAt(i);

            for (int j = 1; j < N; j++) {
                if (c != files[j].charAt(i)) {
                    isSame = false;
                    break;
                }
            }

            if (isSame) {
                sb.append(c);
            } else {
                sb.append("?");
            }
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
