package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2752 {
    static int[] A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        A = new int[3];
        for (int i = 0; i < 3; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {
        Arrays.sort(A);
        System.out.println(A[0] + " " + A[1] + " " + A[2]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
