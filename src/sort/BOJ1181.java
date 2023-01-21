package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1181 {
    static int N;
    static String[] words;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }
    }

    static void pro() {
        Arrays.sort(words, (s1, s2) -> {
            if(s1.length() != s2.length()) return s1.length() - s2.length();
            return s1.compareTo(s2);
        });

        sb.append(words[0]).append('\n');
        for (int i = 1; i < N; i++) {
            if(words[i - 1].equals(words[i])) continue;
            sb.append(words[i]).append('\n');
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
