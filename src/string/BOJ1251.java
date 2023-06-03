package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1251 {
    static String line;
    static ArrayList<String> A;
    static String[] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        line = br.readLine();
        A = new ArrayList<>();
        arr = new String[3];
    }

    static void pro() {
        for (int i = 1; i < line.length() - 1; i++) {
            for (int j = i + 1; j < line.length(); j++) {
                sb = new StringBuilder();
                arr[0] = line.substring(0, i);
                arr[1] = line.substring(i, j);
                arr[2] = line.substring(j, line.length());

                for (int k = 0; k < 3; k++) {
                    for (int l = arr[k].length() - 1; l >= 0; l--) {
                        sb.append(arr[k].charAt(l));
                    }
                }

                A.add(sb.toString());
            }
        }

        Collections.sort(A);
        System.out.println(A.get(0));
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
