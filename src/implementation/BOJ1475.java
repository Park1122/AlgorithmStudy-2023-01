package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1475 {
    static String str;
    static int[] nums;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        str = br.readLine();
        nums = new int[10];
    }

    static void pro() {
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            nums[num]++;
        }

        int k = nums[6] + nums[9];
        if (k % 2 == 0) {
            nums[6] = k / 2;
            nums[9] = k / 2;
        } else {
            nums[6] = k / 2 + 1;
            nums[9] = k / 2 + 1;
        }

        int ans = 0;
        for (int i : nums) {
            ans = Math.max(ans, i);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
