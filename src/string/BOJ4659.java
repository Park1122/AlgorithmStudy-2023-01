package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4659 {
    static String password;
    static final String OK = " is acceptable.";
    static final String NOT_OK = " is not acceptable.";
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        password = br.readLine();
    }

    // 1. 모음 하나를 반드시 포함
    static boolean hasVowel() {
        return password.contains("a") || password.contains("e") || password.contains("i")
                || password.contains("o") || password.contains("u");
    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    // 2. 모음이 3개 혹은 자음이 3개 연속 X
    static boolean isThreeInARow() {
        for (int i = 0; i < password.length() - 2; i++) {
            if (isVowel(password.charAt(i))) {
                // 모음이 3개 연속
                if (isVowel(password.charAt(i + 1)) && isVowel(password.charAt(i + 2))) {
                    return true;
                }
            } else {
                // 자음이 3개 연속
                if (!isVowel(password.charAt(i + 1)) && !isVowel(password.charAt(i + 2))) {
                    return true;
                }
            }
        }
        return false;
    }

    // 3. 같은 글자가 연속 두번 X, ee, oo는 허용
    static boolean isTwoInARow() {
        for (int i = 0; i < password.length() - 1; i++) {
            if (password.charAt(i) == password.charAt(i + 1)) {
                if (password.charAt(i) != 'e' && password.charAt(i) != 'o') {
                    return true;
                }
            }
        }
        return false;
    }

    static void pro() {
        if (hasVowel() && !isThreeInARow() && !isTwoInARow()) {
            sb.append("<").append(password).append(">").append(OK).append('\n');
        } else {
            sb.append("<").append(password).append(">").append(NOT_OK).append('\n');
        }
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            input();
            if ("end".equals(password)) {
                break;
            }
            pro();
        }
        System.out.println(sb.toString());
    }
}
