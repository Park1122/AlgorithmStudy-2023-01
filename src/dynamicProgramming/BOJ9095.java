package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9095 {
    static int[] Dy;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void preprocess() {
        Dy = new int[15];
        Dy[1] = 1;
        Dy[2] = 2;
        Dy[3] = 4;
        for (int i = 4; i <= 11; i++) {
            Dy[i] = Dy[i - 1] + Dy[i - 2] + Dy[i - 3];
        }
    }

    static void pro() throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(Dy[N]).append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        preprocess();
        pro();
    }
}
