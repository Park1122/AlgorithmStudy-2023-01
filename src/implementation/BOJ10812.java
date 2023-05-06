package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10812 {
    static int N, M;
    static ArrayList<Integer> list;
    static int[][] methods;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        methods = new int[M][3];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                methods[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void pro() {
        for (int i = 0; i < N; i++) {
            list.add(i + 1);
        }

        for (int i = 0; i < M; i++) {
            int begin = methods[i][0];
            int end = methods[i][1];
            int mid = methods[i][2];

            int a = list.get(begin - 1);
            int b = list.get(mid - 1);
            while (a != b) {
                list.remove(begin - 1);
                list.add(end - 1, a);
                a = list.get(begin - 1);
            }
        }

        for (int i : list) {
            sb.append(i).append(' ');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
