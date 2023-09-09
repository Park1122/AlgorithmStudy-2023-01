package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4796 {
    static int L, P, V;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
    }

    static void pro() {
        int ans = L * (V / P) + Math.min(L, V % P);
        sb.append(ans).append('\n');
    }

    public static void main(String[] args) throws IOException {
        int t = 1;
        while (true) {
            input();
            if (L == 0 && P == 0 && V == 0) break;
            sb.append("Case ").append(t).append(": ");
            pro();
            t++;
        }
        System.out.println(sb.toString());
    }
}
