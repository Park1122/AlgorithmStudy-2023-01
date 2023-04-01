package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1431 {
    static int N;
    static String[] A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new String[N];
        for (int i = 0; i < N; i++) {
            A[i] = br.readLine();
        }
    }

    static void pro() {
        Arrays.sort(A, (a, b) -> {
            // 1. 길이비교
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }
            // 2. 숫자들의 합 비교
            int sumA = 0, sumB = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) >= '0' && a.charAt(i) <= '9') {
                    sumA += Integer.parseInt(String.valueOf(a.charAt(i)));
                }
            }
            for (int i = 0; i < b.length(); i++) {
                if (b.charAt(i) >= '0' && b.charAt(i) <= '9') {
                    sumB += Integer.parseInt(String.valueOf(b.charAt(i)));
                }
            }
            if (sumA != sumB) {
                return sumA - sumB;
            }
            // 3. 사전순 비교
            return a.compareTo(b);
        });

        for (String str : A) {
            sb.append(str).append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
