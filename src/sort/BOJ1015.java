package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1015 {
    static int N;
    static int[][] B;
    static int[] P;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        // B[i][0] := num
        // B[i][1] := idx
        B = new int[N][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i][0] = Integer.parseInt(st.nextToken());
            B[i][1] = i;
        }
        P = new int[N];
    }

    static void pro() {
        // 정렬하여 B 배열 만들기
        // A배열을 오름차순으로 만들면 B가 되기 때문에 A배열은 생략
        Arrays.sort(B, (a, b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        // B배열 순회하면서 역으로 P배열 값 찾기
        for (int b_idx = 0; b_idx < N; b_idx++) {
            P[B[b_idx][1]] = b_idx;
        }

        for (int i = 0; i < N; i++) {
            sb.append(P[i]).append(' ');
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
