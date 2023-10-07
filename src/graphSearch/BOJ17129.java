package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17129 {
    static int N, M;
    static char[][] A;
    static int[][] dist;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
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
        A = new char[N][M];
        dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            A[i] = br.readLine().toCharArray();
        }
    }

    static void pro() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist[i][j] = -1;
                if (A[i][j] == '2') {
                    dist[i][j] = 0;
                    q.add(i);
                    q.add(j);
                }
            }
        }

        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = x + dir[d][0];
                int ny = y + dir[d][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(A[nx][ny] == '1') continue;
                if(dist[nx][ny] != -1) continue;

                dist[nx][ny] = dist[x][y] + 1;
                q.add(nx);
                q.add(ny);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if ((A[i][j] == '3' || A[i][j] == '4' || A[i][j] == '5') && dist[i][j] != -1) {
                    ans = Math.min(ans, dist[i][j]);
                }
            }
        }

        if (ans == Integer.MAX_VALUE) {
            System.out.println("NIE");
        } else {
            System.out.println("TAK");
            System.out.println(ans);
        }
    }
}
