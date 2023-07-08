package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ5086 {
    static int first, second;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        first = Integer.parseInt(st.nextToken());
        if (first == 0) {
            return;
        }
        second = Integer.parseInt(st.nextToken());
    }

    static void pro() {
        if (second % first == 0) {
            System.out.println("factor");
        } else if (first % second == 0) {
            System.out.println("multiple");
        } else {
            System.out.println("neither");
        }
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            input();
            if (first == 0) {
                break;
            }
            pro();
        }
    }
}
