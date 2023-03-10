package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1969 {
    static int N, M;
    static String[] DNA;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        DNA = new String[N];
        for (int i = 0; i < N; i++) {
            DNA[i] = br.readLine();
        }
    }

    static void pro() {
        // 단어 생성
        int distance = 0;
        for (int i = 0; i < M; i++) {
            // A, C, G, T
            int[] arr = new int[4];
            for (int j = 0; j < N; j++) {
                char c = DNA[j].charAt(i);
                if (c == 'A') {
                    arr[0]++;
                } else if (c == 'C') {
                    arr[1]++;
                } else if (c == 'G') {
                    arr[2]++;
                } else {
                    arr[3]++;
                }
            }

            int idx = 0;
            int max = 0;
            for (int j = 0; j < 4; j++) {
                if (arr[j] > max || (arr[j] == max && idx > j)) {
                    max = arr[j];
                    idx = j;
                }
            }

            if (idx == 0) {
                sb.append('A');
            } else if (idx == 1) {
                sb.append('C');
            } else if (idx == 2) {
                sb.append('G');
            } else {
                sb.append('T');
            }

            distance += N - max;
        }

        System.out.println(sb.toString());
        System.out.println(distance);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
