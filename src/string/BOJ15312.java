package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15312 {
    static String A, B;
    static int[] arr = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        A = br.readLine();
        B = br.readLine();
    }

    static void pro() {
        String line = "";
        for (int i = 0; i < A.length(); i++) {
            line += arr[A.charAt(i) - 'A'];
            line += arr[B.charAt(i) - 'A'];
        }

        while (line.length() > 2) {
            String temp = "";
            for (int i = 0; i < line.length() - 1; i++) {
                int n = Character.getNumericValue(line.charAt(i)) + Character.getNumericValue(line.charAt(i + 1));
                temp += Integer.toString(n % 10);
            }
            line = temp;
        }

        System.out.println(line);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
