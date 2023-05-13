package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2580 {
    static int[][] A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        A = new int[9][9];
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static boolean isPossible(int row, int col, int val) {
        // 가로 체크
        for (int i = 0; i < 9; i++) {
            if (A[row][i] == val) {
                return false;
            }
        }
        // 세로 체크
        for (int i = 0; i < 9; i++) {
            if (A[i][col] == val) {
                return false;
            }
        }

        // 3 x 3 박스 체크
        int setRow = (row / 3) * 3;
        int setCol = (col / 3) * 3;
        for (int i = setRow; i < setRow + 3; i++) {
            for (int j = setCol; j < setCol + 3; j++) {
                if (A[i][j] == val) {
                    return false;
                }
            }
        }

        return true;
    }

    static void sudoku(int x, int y) {
        // 해당 행이 다 채워진 경우 다음 줄로 이동
        if (y == 9) {
            sudoku(x + 1, 0);
        } else {
            // 행과 열이 다 채워진 경우 출력
            if (x == 9) {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        sb.append(A[i][j]).append(' ');
                    }
                    sb.append('\n');
                }
                System.out.println(sb.toString());
                System.exit(0);
            }

            // 빈 칸인 경우
            if (A[x][y] == 0) {
                for (int i = 1; i <= 9; i++) {
                    if (isPossible(x, y, i)) {
                        A[x][y] = i;
                        sudoku(x, y + 1);
                    }
                }
                A[x][y] = 0;
                return;
            }
            // 빈 칸이 아닌 경우
            sudoku(x, y + 1);
        }
    }

    static void pro() {
        sudoku(0, 0);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
