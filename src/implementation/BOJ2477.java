package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2477 {
    static int N, maxH, maxW, maxHIdx, maxWIdx;
    static int[] dir, dist;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        dir = new int[6];
        dist = new int[6];
        maxH = 0;
        maxW = 0;
        maxHIdx = -1;
        maxWIdx = -1;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            dir[i] = Integer.parseInt(st.nextToken());
            dist[i] = Integer.parseInt(st.nextToken());
            if (dir[i] == 1 || dir[i] == 2) {
                // 가로 방향
                if (maxH < dist[i]) {
                    maxH = dist[i];
                    maxHIdx = i;
                }
            } else {
                // 세로 방향
                if (maxW < dist[i]) {
                    maxW = dist[i];
                    maxWIdx = i;
                }
            }
        }
    }

    static void pro() {
        int maxSquare = maxH * maxW;
        int minSquare = dist[(maxHIdx + 3) % 6] * dist[(maxWIdx + 3) % 6];
        int ans = N * (maxSquare - minSquare);

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
