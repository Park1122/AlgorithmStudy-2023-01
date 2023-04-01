package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ2210 {
    static HashSet<String> set;
    static String[][] A;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        A = new String[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                A[i][j] = st.nextToken();
            }
        }
        set = new HashSet<>();
    }

    static void dfs(int x, int y, String str) {
        if (str.length() == 6) {
            set.add(str);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dir[d][0];
            int ny = y + dir[d][1];

            if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
            dfs(nx, ny, str + A[nx][ny]);
        }
    }

    static void pro() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, A[i][j]);
            }
        }

        System.out.println(set.size());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
