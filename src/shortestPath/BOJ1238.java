package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1238 {
    static class Edge {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Info {
        int idx, dist;

        public Info(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    static int N, M, X;
    static ArrayList<Edge>[] edges;
    static int[][] dist;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        edges = new ArrayList[N + 1];
        dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[start].add(new Edge(end, weight));
        }
    }

    static void dijkstra(int start) {
        for (int i = 1; i <= N; i++) {
            dist[start][i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Info> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.add(new Info(start, 0));
        dist[start][start] = 0;

        while (!pq.isEmpty()) {
            Info info = pq.poll();
            if(dist[start][info.idx] != info.dist) continue;

            for (Edge e : edges[info.idx]) {
                if(dist[start][info.idx] + e.weight >= dist[start][e.to]) continue;
                dist[start][e.to] = dist[start][info.idx] + e.weight;
                pq.add(new Info(e.to, dist[start][e.to]));
            }
        }
    }

    static void pro() {
        for (int i = 1; i <= N; i++) {
            dijkstra(i);
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, dist[i][X] + dist[X][i]);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
