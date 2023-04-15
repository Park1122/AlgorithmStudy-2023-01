package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1476 {
    static int E, S, M; // E 1~15, S 1~28, M 1~19
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    }

    static void pro() {
        int year = 0;
        int e = 0, s = 0, m = 0;

        while (true) {
            e++; s++; m++;
            if(e > 15) e = 1;
            if(s > 28) s = 1;
            if(m > 19) m = 1;
            year++;

            if (e == E && s == S && m == M) {
                break;
            }
        }

        System.out.println(year);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
