package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ5635 {
    static int N;
    static String[][] people;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        people = new String[N][4];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            people[i][0] = st.nextToken(); // name
            people[i][1] = st.nextToken(); // day
            people[i][2] = st.nextToken(); // month
            people[i][3] = st.nextToken(); // year
        }
    }

    static void pro() {
        Arrays.sort(people, (a, b) -> {
            if(!a[3].equals(b[3])) return Integer.parseInt(a[3]) - Integer.parseInt(b[3]);
            if(!a[2].equals(b[2])) return Integer.parseInt(a[2]) - Integer.parseInt(b[2]);
            return Integer.parseInt(a[1]) - Integer.parseInt(b[1]);
        });

        System.out.println(people[N - 1][0]);
        System.out.println(people[0][0]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
