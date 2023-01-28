package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502 {
    static int N, M, ans, wallCnt;
    static int[][] map, walls;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // 0은 빈칸, 1은 벽, 2는 바이러스
        map = new int[N + 1][M + 1];
        visit = new boolean[N + 1][M + 1];
        // walls[i][0] := i번째 벽이 놓일 수 있는 위치의 x좌표, walls[i][1] := i번째 벽이 놓일 수 있는 위치의 y좌표
        walls = new int[N * M + 1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = Integer.MIN_VALUE;
        wallCnt = 0;
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                visit[i][j] = false;

                if (map[i][j] == 2) {
                    q.add(i);
                    q.add(j);
                    visit[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = x + dir[d][0];
                int ny = y + dir[d][1];
                if(nx < 1 || ny < 1 || nx > N || ny > M) continue;
                if(visit[nx][ny]) continue;
                if(map[nx][ny] != 0) continue;

                q.add(nx);
                q.add(ny);
                visit[nx][ny] = true;
            }
        }

        // 안전구역 크기 구하기
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (!visit[i][j] && map[i][j] == 0) cnt++;
            }
        }
        ans = Math.max(cnt, ans);
    }

    static void dfs(int idx, int k) {
        if (k == 3) {
            bfs();
        } else {
            if(idx > wallCnt) return;

            // 해당 idx의 벽을 선택
            map[walls[idx][0]][walls[idx][1]] = 1;
            dfs(idx + 1, k + 1);

            // 복구
            map[walls[idx][0]][walls[idx][1]] = 0;

            // 해당 idx의 벽을 미선택
            dfs(idx + 1, k);
        }
    }

    static void pro() {
        // 벽이 세워질 수 있는 모든 위치의 좌표를 저장
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 0) {
                    wallCnt++;
                    walls[wallCnt][0] = i;
                    walls[wallCnt][1] = j;
                }
            }
        }

        // 벽을 세워보고 안전구역의 크기 찾기 -> walls에서 3개 뽑아보고, 안전구역 크기 구해서 대소비교
        dfs(1, 0);

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
