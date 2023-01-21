package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10825 {
    static class Person {
        String name;
        int korean, english, math;

        public Person(String n, int k, int e, int m) {
            this.name = n;
            this.korean = k;
            this.english = e;
            this.math = m;
        }
    }

    static int N;
    static Person[] people;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        people = new Person[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            people[i] = new Person(name, kor, eng, math);
        }
    }

    static void pro() {
        Arrays.sort(people, (p1, p2) -> {
            if(p1.korean != p2.korean) return p2.korean - p1.korean;
            if(p1.english != p2.english) return p1.english - p2.english;
            if(p1.math != p2.math) return p2.math - p1.math;
            return p1.name.compareTo(p2.name);
        });

        for (Person p : people) {
            sb.append(p.name).append('\n');
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
        System.out.println(sb.toString());
    }
}
