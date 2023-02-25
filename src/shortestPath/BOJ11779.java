package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ11779 {
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

    static int N, M, A, B;
    static ArrayList<Edge>[] edges;
    static int[] dist, route;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dist = new int[N + 1];
        // route[i] := i번째 노드 오기 전에 노드 번호 기록
        route = new int[N + 1];
        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) edges[i] = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[start].add(new Edge(end, weight));
        }
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
    }

    static void dijkstra(int start) {
        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Info> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.add(new Info(start, 0));
        dist[start] = 0;
        route[start] = 0;

        while (!pq.isEmpty()) {
            Info info = pq.poll();
            if(dist[info.idx] != info.dist) continue;

            for (Edge e : edges[info.idx]) {
                if(dist[info.idx] + e.weight >= dist[e.to]) continue;
                dist[e.to] = dist[info.idx] + e.weight;
                pq.add(new Info(e.to, dist[e.to]));
                route[e.to] = info.idx;
            }
        }
    }

    static void pro() {
        dijkstra(A);

        // 경로 기록하기
        Stack<Integer> temp = new Stack<>();
        int cur = B;
        while (cur != 0) {
            temp.push(cur);
            cur = route[cur];
        }

        sb.append(dist[B]).append('\n');
        sb.append(temp.size()).append('\n');
        while (!temp.isEmpty()) {
            sb.append(temp.pop()).append(' ');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
