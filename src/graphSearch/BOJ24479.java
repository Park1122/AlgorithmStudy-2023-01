package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ24479 {
    static int N, M, R, idx;
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    static int[] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        // 오름차순 방문을 위한 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
        arr = new int[N + 1];
    }

    static void dfs(int start) {
        visit[start] = true;
        arr[start] = idx;

        for (int i : graph[start]) {
            if(visit[i]) continue;
            idx++;
            dfs(i);
        }
    }

    static void pro() {
        idx = 1;
        dfs(R);

        for (int i = 1; i <= N; i++) {
            sb.append(arr[i]).append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
