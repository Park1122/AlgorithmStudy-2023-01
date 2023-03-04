package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2960 {
    static int N, K;
    static boolean[] nums;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nums = new boolean[N + 1];
    }

    static void pro() {
        int cnt = 0;
        for (int i = 2; i <= N; i++) {
            for (int j = i; j <= N; j += i) {
                if(nums[j]) continue;
                cnt++;
                nums[j] = true;

                if (cnt == K) {
                    System.out.println(j);
                    System.exit(0);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
