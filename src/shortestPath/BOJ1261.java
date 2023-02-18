package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1261 {
    static class Edge {
        int x, y, cnt;

        public Edge(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static int N, M;
    static String[] A;
    static int[][] dist;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        A = new String[N];
        dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            A[i] = br.readLine();
        }
    }

    static void dijkstra(int startX, int startY) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cnt - b.cnt);
        pq.add(new Edge(startX, startY, 0));
        dist[startX][startY] = 0;

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            for (int d = 0; d < 4; d++) {
                int nx = e.x + dir[d][0];
                int ny = e.y + dir[d][1];
                int nCnt = e.cnt;

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (A[nx].charAt(ny) == '1') {
                    nCnt++;
                }
                if (dist[nx][ny] > nCnt) {
                    dist[nx][ny] = nCnt;
                    pq.add(new Edge(nx, ny, nCnt));
                }
            }
        }
    }

    static void pro() {
        dijkstra(0, 0);
        System.out.println(dist[N - 1][M - 1]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
