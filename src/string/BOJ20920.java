package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ20920 {
    static class Word {
        String name;
        int cnt;

        public Word(String name, int cnt) {
            this.name = name;
            this.cnt = cnt;
        }
    }

    static int N, M;
    static String[] A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new String[N];
        for (int i = 0; i < N; i++) {
            A[i] = br.readLine();
        }
    }

    static void pro() {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if(A[i].length() < M) continue;
            if (map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
            } else {
                map.put(A[i], 1);
            }
        }

        ArrayList<Word> list = new ArrayList<>();
        for (String s : map.keySet()) {
            list.add(new Word(s, map.get(s)));
        }
        Collections.sort(list, (a, b) -> {
            if(a.cnt != b.cnt) return b.cnt - a.cnt;
            if(a.name.length() != b.name.length()) return b.name.length() - a.name.length();
            return a.name.compareTo(b.name);
        });

        for (Word w : list) {
            sb.append(w.name).append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
