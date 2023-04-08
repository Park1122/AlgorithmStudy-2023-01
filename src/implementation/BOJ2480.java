package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2480 {
    static int[] dices;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        dices = new int[3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            dices[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {
        int ans = 0;
        if (dices[0] == dices[1] && dices[1] == dices[2]) {
            ans = 10000 + dices[0] * 1000;
        } else if (dices[0] == dices[1] || dices[1] == dices[2] || dices[0] == dices[2]) {
            if (dices[0] == dices[1]) {
                ans = 1000 + dices[0] * 100;
            } else if (dices[1] == dices[2]) {
                ans = 1000 + dices[1] * 100;
            } else {
                ans = 1000 + dices[0] * 100;
            }
        } else {
            ans = Math.max(dices[0], Math.max(dices[1], dices[2])) * 100;
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
