package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ18352 {
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

    static int N, M, K, X;
    static int[] dist;
    static ArrayList<Edge>[] edges;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        dist = new int[N + 1];
        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) edges[i] = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(new Edge(b, 1));
        }
    }

    static void dijkstra(int start) {
        for (int i = 1; i <= N; i++) dist[i] = Integer.MAX_VALUE;
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
    }

    static void pro() {
        dijkstra(X);

        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if(dist[i] == K) temp.add(i);
        }

        if (!temp.isEmpty()) {
            for (int i : temp) {
                sb.append(i).append('\n');
            }
            System.out.println(sb.toString());
        } else {
            System.out.println(-1);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
