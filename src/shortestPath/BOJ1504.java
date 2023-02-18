package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1504 {
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

    static int N, E, V1, V2;
    static int[] dist;
    static ArrayList<Edge>[] edges;
    static final int INF = 200_000_000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        dist = new int[N + 1];
        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[start].add(new Edge(end, weight));
            edges[end].add(new Edge(start, weight));
        }
        st = new StringTokenizer(br.readLine());
        V1 = Integer.parseInt(st.nextToken());
        V2 = Integer.parseInt(st.nextToken());
    }

    static int dijkstra(int start, int end) {
        for (int i = 1; i <= N; i++) {
            dist[i] = INF;
        }

        PriorityQueue<Info> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.add(new Info(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Info info = pq.poll();
            if(dist[info.idx] != info.dist) continue;

            for (Edge e : edges[info.idx]) {
                if(dist[info.idx] + e.weight >= dist[e.to]) continue;

                dist[e.to] = dist[info.idx] + e.weight;
                pq.add(new Info(e.to, dist[e.to]));
            }
        }

        return dist[end];
    }

    static void pro() {
        int result1 = dijkstra(1, V1);
        result1 += dijkstra(V1, V2);
        result1 += dijkstra(V2, N);

        int result2 = dijkstra(1, V2);
        result2 += dijkstra(V2, V1);
        result2 += dijkstra(V1, N);

        if (result1 == INF && result2 == INF) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(result1, result2));
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
