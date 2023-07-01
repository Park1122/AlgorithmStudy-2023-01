package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ26069 {
    static int N;
    static String[][] A;
    static HashMap<String, Integer> dance;
    static final String R = "ChongChong";
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new String[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i][0] = st.nextToken();
            A[i][1] = st.nextToken();
        }
        dance = new HashMap<>();
    }

    static void pro() {
        for (int i = 0; i < N; i++) {
            String a = A[i][0];
            String b = A[i][1];

            if (dance.containsKey(a)) {
                if (dance.get(a) == 1) {
                    dance.put(b, 1);
                    continue;
                }
            }
            if (dance.containsKey(b)) {
                if (dance.get(b) == 1) {
                    dance.put(a, 1);
                    continue;
                }
            }

            if (a.equals(R) || b.equals(R)) {
                dance.put(a, 1);
                dance.put(b, 1);
            } else {
                dance.put(a, 0);
                dance.put(b, 0);
            }
        }

        int ans = 0;
        for (String n : dance.keySet()) {
            if (dance.get(n) == 1) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
