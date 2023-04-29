package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2529 {
    static int N;
    static boolean[] visited;
    static ArrayList<String> ans;
    static String[] signs;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine()); // 부등호 개수는 N, 숫자 개수는 N+1
        visited = new boolean[10];
        ans = new ArrayList<>();
        signs = new String[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            signs[i] = st.nextToken();
        }
    }

    static boolean compare(int a, int b, String sign) {
        if ("<".equals(sign)) {
            return a < b;
        } else {
            return a > b;
        }
    }

    static void recFunc(int depth, String line) {
        if (depth == N + 2) {
            ans.add(line);
        } else {
            for (int cand = 0; cand <= 9; cand++) {
                if(visited[cand]) continue;
                if (depth == 1 || compare(line.charAt(depth - 2) - '0', cand, signs[depth - 2])) {
                    visited[cand] = true;
                    recFunc(depth + 1, line + cand);
                    visited[cand] = false;
                }
            }
        }
    }

    static void pro() {
        recFunc(1, "");
        Collections.sort(ans);
        System.out.println(ans.get(ans.size() - 1));
        System.out.println(ans.get(0));
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
