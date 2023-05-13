package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ25192 {
    static int N;
    static String[] A;
    static HashSet<String> set;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new String[N];
        for (int i = 0; i < N; i++) {
            A[i] = br.readLine();
        }
        set = new HashSet<>();
    }

    static void pro() {
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (A[i].equals("ENTER")) {
                set = new HashSet<>();
            } else {
                if (!set.contains(A[i])) {
                    set.add(A[i]);
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
