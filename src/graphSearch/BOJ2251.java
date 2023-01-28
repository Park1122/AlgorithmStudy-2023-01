package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2251 {
    // 각 물병의 상태 및 변화를 관리하는 객체
    static class State {
        int[] X;

        public State(int[] newX) {
            X = new int[3];
            for (int i = 0; i < 3; i++) X[i] = newX[i];
        }

        public State move(int from, int to, int[] limit) {
            int[] nX = new int[]{X[0], X[1], X[2]};
            if (X[from] + X[to] >= limit[to]) { // 물은 옮겼더니 from에 남는 경우
                nX[from] -= limit[to] - X[to];
                nX[to] = limit[to];
            } else { // 안남는 경우
                nX[to] += nX[from];
                nX[from] = 0;
            }
            return new State(nX);
        }
    }

    static int[] Limit;
    static boolean[][][] visit;
    static boolean[] pos;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        Limit = new int[3];
        for (int i = 0; i < 3; i++) {
            Limit[i] = Integer.parseInt(st.nextToken());
        }
        pos = new boolean[205];
        visit = new boolean[205][205][205];
    }

    static void bfs(int x1, int x2, int x3) {
        Queue<State> q = new LinkedList<>();
        q.add(new State(new int[]{x1, x2, x3}));
        visit[x1][x2][x3] = true;

        while (!q.isEmpty()) {
            State now = q.poll();
            if (now.X[0] == 0) { // 1번째 물병이 비워진 경우
                pos[now.X[2]] = true;
            }

            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if(from == to) continue;
                    State next = now.move(from, to, Limit);

                    if(visit[next.X[0]][next.X[1]][next.X[2]]) continue;
                    visit[next.X[0]][next.X[1]][next.X[2]] = true;
                    q.add(next);
                }
            }
        }
    }

    static void pro() {
        bfs(0, 0, Limit[2]);

        for (int i = 0; i <= Limit[2]; i++) {
            if(pos[i]) sb.append(i).append(' ');
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
