package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1302 {
    static class Book {
        String name;
        int cnt;

        public Book(String name, int cnt) {
            this.name = name;
            this.cnt = cnt;
        }
    }

    static int N;
    static ArrayList<Book> books;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        books = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            boolean flag = false;
            for (Book b : books) {
                if (name.equals(b.name)) {
                    b.cnt++;
                    flag = true;
                }
            }
            if (!flag) {
                books.add(new Book(name, 1));
            }
        }
    }

    static void pro() {
        Collections.sort(books, (a, b) -> {
            if(a.cnt != b.cnt) return b.cnt - a.cnt;
            return a.name.compareTo(b.name);
        });
        System.out.println(books.get(0).name);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
