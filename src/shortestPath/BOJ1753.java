package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1753 {
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
    static int V, E, K;
    static int[] dist;
    static ArrayList<Edge>[] edges;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        dist = new int[V + 1];
        edges = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[start].add(new Edge(end, weight));
        }
    }

    static void dijkstra(int start) {
        for (int i = 1; i <= V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Info> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.add(new Info(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Info info = pq.poll();
            if(dist[info.idx] != info.dist) continue;

            for (Edge edge : edges[info.idx]) {
                if(dist[info.idx] + edge.weight >= dist[edge.to]) continue;

                dist[edge.to] = dist[info.idx] + edge.weight;
                pq.add(new Info(edge.to, dist[edge.to]));
            }
        }
    }

    static void pro() {
        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF").append('\n');
            } else {
                sb.append(dist[i]).append('\n');
            }
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
