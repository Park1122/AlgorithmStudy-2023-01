package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13305 {
    static int N;
    static long[] dist, cost;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        dist = new long[N - 1]; // 도로 거리
        cost = new long[N]; // 주유소 가격
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            dist[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }
    }

    static void pro() {
        long ans = 0;
        long min = cost[0]; // 이전까지의 주유소 가격 중 최소 비용
        for (int i = 0; i < N - 1; i++) {
            // 현재 주유소가 이전 주유소보다 가격이 쌀 경우 갱신
            if (cost[i] < min) {
                min = cost[i];
            }

            ans += min * dist[i];
        }

        System.out.println(ans);
    }
}
