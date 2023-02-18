package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1439 {
    static String str;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        str = br.readLine();
    }

    static void pro() {
        st = new StringTokenizer(str, "0");
        int count1 = st.countTokens();
        st = new StringTokenizer(str, "1");
        int count2 = st.countTokens();

        System.out.println(Math.min(count1, count2));
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
