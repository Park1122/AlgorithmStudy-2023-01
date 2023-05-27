package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2743 {
    static String line;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        line = br.readLine();
    }

    static void pro() {
        System.out.println(line.length());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
