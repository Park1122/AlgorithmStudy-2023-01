package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9996 {
    static int N;
    static String T;
    static String[] A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        T = br.readLine();
        A = new String[N];
        for (int i = 0; i < N; i++) {
            A[i] = br.readLine();
        }
    }

    static void pro() {
        st = new StringTokenizer(T, "*");

        String a = st.nextToken();
        String b = st.nextToken();
        for (int i = 0; i < N; i++) {
            String s = A[i];
            if (a.length() + b.length() > s.length()) {
                sb.append("NE").append('\n');
                continue;
            }

            String start = s.substring(0, a.length());
            String end = s.substring(s.length() - b.length(), s.length());

            if (start.equals(a) && end.equals(b)) {
                sb.append("DA").append('\n');
            } else {
                sb.append("NE").append('\n');
            }
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
