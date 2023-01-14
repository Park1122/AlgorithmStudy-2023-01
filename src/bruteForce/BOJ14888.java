package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888 {
    static int N, min, max;
    static int[] A, op;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        op = new int[4 + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }

    static int calculate(int num1, int op, int num2) {
        if (op == 1) {
            return num1 + num2;
        } else if (op == 2) {
            return num1 - num2;
        } else if (op == 3) {
            return num1 * num2;
        } else {
            return num1 / num2;
        }
    }

    static void recFunc(int k, int val) {
        // 1 ~ N-1 개의 연산자가 사용
        if (k == N) {
            min = Math.min(min, val);
            max = Math.max(max, val);
        } else {
            for (int i = 1; i <= 4; i++) {
                if (op[i] >= 1) {
                    op[i]--;
                    recFunc(k + 1, calculate(val, i, A[k + 1]));
                    op[i]++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        recFunc(1, A[1]);
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());
    }
}
