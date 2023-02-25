package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2587 {
    static int[] nums;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        nums = new int[5];
        for (int i = 0; i < 5; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
    }

    static void pro() {
        Arrays.sort(nums);

        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        System.out.println(sum / 5);
        System.out.println(nums[2]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
