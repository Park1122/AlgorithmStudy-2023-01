package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ24511 {
    static int N, M;
    static int[] structures; // queue = 0, stack = 1
    static int[] data;
    static ArrayDeque<Integer> dq;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        structures = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            structures[i] = Integer.parseInt(st.nextToken());
        }
        dq = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (structures[i] == 0) {
                dq.addLast(n);
            }
        }
        M = Integer.parseInt(br.readLine());
        data = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {
        for (int i = 0; i < M; i++) {
            int now = data[i];
            dq.addFirst(now);
            sb.append(dq.pollLast()).append(" ");
        }

        System.out.println(sb.toString());
    }
}
