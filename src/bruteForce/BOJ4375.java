package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ4375 {
    static BigInteger N;
    static String line;
    static boolean isStop;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        line = br.readLine();
        if (line == null) {
            isStop = true;
            return;
        }
        N = new BigInteger(line);
    }

    static void pro() {
        BigInteger num = BigInteger.ONE;
        while (true) {
            if (num.mod(N).equals(BigInteger.ZERO)) {
                sb.append(num.toString().length()).append('\n');
                break;
            }
            num = num.multiply(BigInteger.TEN).add(BigInteger.ONE);
        }
    }

    public static void main(String[] args) throws IOException {
        isStop = false;
        while (true) {
            input();
            if (isStop) {
                break;
            }
            pro();
        }
        System.out.println(sb.toString());
    }
}
