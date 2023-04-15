package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ4485 {
    static class Edge {
        int x, y, cnt;

        public Edge(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static int N, step;
    static int[][] A, dist;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean isStop;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        if (N == 0) {
            isStop = true;
            return;
        }
        A = new int[N][N];
        dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    static void dijkstra(int startX, int startY) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cnt - b.cnt);
        pq.add(new Edge(startX, startY, A[startX][startY]));
        dist[startX][startY] = A[startX][startY];

        while (!pq.isEmpty()) {
            Edge e = pq.poll();

            for (int d = 0; d < 4; d++) {
                int nx = e.x + dir[d][0];
                int ny = e.y + dir[d][1];
                int nCnt = e.cnt;

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                nCnt += A[nx][ny];
                if (dist[nx][ny] > nCnt) {
                    dist[nx][ny] = nCnt;
                    pq.add(new Edge(nx, ny, nCnt));
                }
            }
        }
    }

    static void pro() {
        dijkstra(0, 0);
        sb.append("Problem ").append(step).append(": ").append(dist[N - 1][N - 1]).append('\n');
    }

    public static void main(String[] args) throws IOException {
        isStop = false;
        step = 0;
        while (true) {
            step++;
            input();
            if (isStop) {
                break;
            }
            pro();
        }
        System.out.println(sb.toString());
    }
}
