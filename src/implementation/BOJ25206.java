package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ25206 {
    static String[] A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        A = new String[20];
        for (int i = 0; i < 20; i++) {
            A[i] = br.readLine();
        }
    }

    static void pro() {
        double sum = 0;
        double grade = 0;
        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(A[i]);
            st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String g = st.nextToken();
            if (g.equals("A+")) {
                grade += score * 4.5;
                sum += score;
            } else if (g.equals("A0")) {
                grade += score * 4.0;
                sum += score;
            } else if (g.equals("B+")) {
                grade += score * 3.5;
                sum += score;
            } else if (g.equals("B0")) {
                grade += score * 3.0;
                sum += score;
            } else if (g.equals("C+")) {
                grade += score * 2.5;
                sum += score;
            } else if (g.equals("C0")) {
                grade += score * 2.0;
                sum += score;
            } else if (g.equals("D+")) {
                grade += score * 1.5;
                sum += score;
            } else if (g.equals("D0")) {
                grade += score * 1.0;
                sum += score;
            } else if (g.equals("F")) {
                sum += score;
            }
        }

        System.out.println(grade / sum);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
