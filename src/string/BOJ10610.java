package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10610 {
    static String A;
    static char[] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        A = br.readLine();
        arr = A.toCharArray();
    }

    static void pro() {
        int sum = 0;
        Arrays.sort(arr);

        for (int i = arr.length - 1; i >= 0; i--) {
            int n = arr[i] - '0';
            sum += n;
            sb.append(n);
        }

        if (arr[0] != '0' || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
