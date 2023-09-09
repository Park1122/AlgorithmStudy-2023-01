package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1789 {
    static long S;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        S = Long.parseLong(br.readLine());
    }

    static void pro() {
        long sum = 0;
        int i = 1;
        while (true) {
            sum += i;
            if(sum > S) break;
            i++;
        }

        System.out.println(i - 1);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
