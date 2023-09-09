package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1343 {
    static String line;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        line = br.readLine();
    }

    static void pro() {
        String A = "AAAA";
        String B = "BB";

        line = line.replace("XXXX", A).replace("XX", B);

        if (line.contains("X")) {
            System.out.println("-1");
        } else {
            System.out.println(line);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
