package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2947 {
    static int[] A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        A = new int[6];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 5; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void swap(int x, int y) {
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }

    static void print() {
        sb.append(A[1]).append(' ').append(A[2]).append(' ').append(A[3]).append(' ')
                .append(A[4]).append(' ').append(A[5]).append('\n');
    }

    static void pro() {
        while (true) {
            // step1
            if (A[1] > A[2]) {
                swap(1, 2);
                print();
            }
            // step2
            if (A[2] > A[3]) {
                swap(2, 3);
                print();
            }
            // step3
            if (A[3] > A[4]) {
                swap(3, 4);
                print();
            }
            // step4
            if (A[4] > A[5]) {
                swap(4, 5);
                print();
            }

            // step5
            if (A[1] == 1 &&A[2] == 2 && A[3] == 3 && A[4] == 4 && A[5] == 5) {
                break;
            }
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
