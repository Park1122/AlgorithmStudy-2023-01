package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ17413 {
    static String line;
    static Stack<Character> stack;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        line = br.readLine();
        stack = new Stack<>();
    }

    static void pro() {
        boolean isBracket = false;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                isBracket = true;
            } else if (c == '>') {
                isBracket = false;
                sb.append(c);
                continue;
            }

            if (isBracket) {
                sb.append(c);
            } else {
                // c가 공백인 경우, 기존 stack 원소들을 pop한 후 공백 추가
                if (c == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                    continue;
                } else {
                    stack.push(c);
                }
            }

            // 마지막까지 왔는데 스택이 비워져있지 않다면 추가
            if (i == line.length() - 1) {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
