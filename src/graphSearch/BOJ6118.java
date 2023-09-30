package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ6118 {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static int[] dist;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
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
        dist = new int[N + 1];
    }

    static void pro() {
        for (int i = 1; i <= N; i++) {
            dist[i] = -1;
        }

        bfs(1);

        int maxIndex = 0;
        int maxValue = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] > maxValue) {
                maxIndex = i;
                maxValue = dist[i];
            }
        }
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (maxValue == dist[i]) {
                cnt++;
            }
        }

        System.out.println(maxIndex + " " + maxValue + " " + cnt);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int x = q.poll();

            for (int nx : graph[x]) {
                if(dist[nx] != -1) continue;
                dist[nx] = dist[x] + 1;
                q.add(nx);
            }
        }
    }
}
