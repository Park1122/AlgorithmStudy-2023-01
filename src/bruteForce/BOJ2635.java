package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2635 {
    static int N;
    static ArrayList<Integer> result;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        result = new ArrayList<>();
    }

    static void pro() {
        for (int i = 1; i <= N; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(N);
            temp.add(i);

            int prevPrev = N;
            int prev = i;
            while (true) {
                int now = prevPrev - prev;
                if (now < 0) {
                    if (result.size() < temp.size()) {
                        result = temp;
                    }
                    break;
                }
                temp.add(now);
                prevPrev = prev;
                prev = now;
            }
        }

        sb.append(result.size()).append('\n');
        for (int i : result) {
            sb.append(i).append(' ');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
