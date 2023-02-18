package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11656 {
    static String S;
    static String[] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        S = br.readLine();
        arr = new String[S.length()];
    }

    static void pro() {
        for (int i = 0; i < S.length(); i++) {
            arr[i] = S.substring(i);
        }
        Arrays.sort(arr);

        for (String s : arr) {
            sb.append(s).append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
