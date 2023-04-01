package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1072 {
    static long X, Y, Z;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());
        Z = 100 * Y / X;
    }

    static void pro() {
        if (Z >= 99) {
            System.out.println(-1);
        } else {
            long L = 0;
            long R = X;
            while (L <= R) {
                long mid = (L + R) / 2;
                long ratio = 100 * (Y + mid) / (X + mid);
                if (ratio > Z) {
                    R = mid - 1;
                } else {
                    L = mid + 1;
                }
            }

            System.out.println(L);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
