package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ5568 {
    static int N, M;
    static int[] cards, selected;
    static boolean[] visited;
    static HashSet<Integer> set;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        cards = new int[N + 1];
        selected = new int[M + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            cards[i] = Integer.parseInt(br.readLine());
        }
        set = new HashSet<>();
    }

    static void recFunc(int k) {
        if (k == M + 1) {
            sb = new StringBuilder();
            for (int i = 1; i <= M; i++) {
                sb.append(cards[selected[i]]);
            }
            set.add(Integer.parseInt(sb.toString()));
        } else {
            for (int i = 1; i <= N; i++) {
                if(visited[i]) continue;
                selected[k] = i;
                visited[i] = true;
                recFunc(k + 1);
                selected[k] = 0;
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        recFunc(1);
        System.out.println(set.size());
    }
}
