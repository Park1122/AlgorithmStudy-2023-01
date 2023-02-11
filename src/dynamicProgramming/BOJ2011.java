package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2011 {
    static String str;
    static int N;
    static int[] Dy;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        str = br.readLine();
        N = str.length();
    }

    // 두 숫자를 묶었을 때, 하나의 수로 해독이 가능한가?
    static boolean check(char A, char B) {
        if(A == '0') return false;
        if(A == '1') return true;
        if(A >= '3') return false;
        return B <= '6';
    }

    static void pro() {
        Dy = new int[N];
        if (str.charAt(0) != '0') {
            Dy[0] = 1;
        }

        for (int i = 1; i < N; i++) {
            // i번 숫자를 단독으로 해석이 가능한 경우
            if (str.charAt(i) != '0') {
                Dy[i] = Dy[i - 1];
            }

            // i-1번과 i번 숫자를 하나로 해석이 가능한 경우
            if (check(str.charAt(i - 1), str.charAt(i))) {
                if(i >= 2) Dy[i] += Dy[i - 2];
                else Dy[i] += 1;
                Dy[i] %= 1000000;
            }
        }

        System.out.println(Dy[N - 1]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
