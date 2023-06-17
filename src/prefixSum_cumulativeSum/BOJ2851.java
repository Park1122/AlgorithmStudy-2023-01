package prefixSum_cumulativeSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2851 {
    static int[] A, prefixSum;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        A = new int[11];
        for (int i = 1; i <= 10; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        prefixSum = new int[11];
    }

    static void pro() {
        int ans = 0;
        for (int i = 1; i <= 10; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
            int diff = Math.abs(100 - prefixSum[i]);
            int temp = Math.abs(100 - ans);
            if(temp < diff) continue;
            ans = prefixSum[i];
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
