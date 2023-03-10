package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1009 {
    static int N, M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    }

    static void pro() {
        int result = 1;
        for (int i = 0; i < M; i++) {
            result = (result * N) % 10;
        }
        if(result == 0) result = 10;
        sb.append(result).append('\n');
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input();
            pro();
        }
        System.out.println(sb.toString());
    }
}
