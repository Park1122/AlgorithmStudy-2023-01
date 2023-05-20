package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ4358 {
    static int total;
    static HashMap<String, Integer> map;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        map = new HashMap<>();
        String line;
        while ((line = br.readLine()) != null) {
            if (map.containsKey(line)) {
                map.put(line, map.get(line) + 1);
            } else {
                map.put(line, 1);
            }
            total++;
        }
    }

    static void pro() {
        ArrayList<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for (String s : list) {
            double per = map.get(s) * 100.0 / total;
            sb.append(s).append(' ').append(String.format("%.4f", per)).append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
