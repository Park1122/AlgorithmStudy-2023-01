package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ9935 {
    static String str, ignition;
    static Stack<Character> stack;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        str = br.readLine();
        ignition = br.readLine();
        stack = new Stack<>();
    }

    static void pro() {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            stack.push(c);

            if (stack.size() >= ignition.length()) {
                boolean f = true;
                for (int j = 0; j < ignition.length(); j++) {
                    if (stack.get(stack.size() - ignition.length() + j) != ignition.charAt(j)) {
                        f = false;
                        break;
                    }
                }

                if (f) {
                    for (int j = 0; j < ignition.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            for (char c : stack) {
                sb.append(c);
            }
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
