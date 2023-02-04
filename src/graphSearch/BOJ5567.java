package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5567 {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static int[] dist;
    static boolean[] visit;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dist = new int[N + 1];
        visit = new boolean[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start] = true;
        dist[start] = 0;

        while (!q.isEmpty()) {
            int x = q.poll();
            for (int y : graph[x]) {
                if(visit[y]) continue;
                q.add(y);
                visit[y] = true;
                dist[y] = dist[x] + 1;
            }
        }
    }

    static void pro() {
        bfs(1);

        int ans = 0;
        for (int i = 2; i <= N; i++) {
            if (dist[i] == 1 || dist[i] == 2) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
