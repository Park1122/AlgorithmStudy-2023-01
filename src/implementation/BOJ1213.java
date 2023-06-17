package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1213 {
    static String A;
    static int[] alphabets;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        A = br.readLine();
        alphabets = new int[26];
    }

    static void pro() {
        String ans = "";
        // 알파벳 개수 구하기
        for (int i = 0; i < A.length(); i++) {
            alphabets[A.charAt(i) - 'A']++;
        }

        int isOne = 0;
        for (int i = 0; i < alphabets.length; i++) {
            if(alphabets[i] % 2 != 0) isOne++;
        }
        if (isOne > 1) {
            ans = "I'm Sorry Hansoo";
        } else {
            // front
            for (int i = 0; i < alphabets.length; i++) {
                for (int j = 0; j < alphabets[i] / 2; j++) {
                    sb.append((char) (i + 'A'));
                }
            }
            ans += sb.toString();
            // end
            String end = sb.reverse().toString();
            sb = new StringBuilder();

            // mid
            for (int i = 0; i < alphabets.length; i++) {
                if (alphabets[i] % 2 != 0) {
                    sb.append((char) (i + 'A'));
                }
            }
            ans += sb.toString() + end;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
