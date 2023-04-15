package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ9375 {
    static int N;
    static HashMap<String, Integer> map;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken(); // 이름은 중요하지 않음
            String kind = st.nextToken(); // 종류별로 몇 개가 있는지가 중요

            if (map.containsKey(kind)) {
                map.put(kind, map.get(kind) + 1);
            } else {
                map.put(kind, 1);
            }
        }
    }

    static void pro() {
        int res = 1;
        for (int i : map.values()) {
            res *= (i + 1); // 특정 종류의 의상을 선택하지 않은 경우도 포함해야 하기 때문에 +1
        }
        res--; // 맨몸인 경우 제외
        sb.append(res).append('\n');
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input();
            pro();
        }
        System.out.println(sb.toString());
    }
}
