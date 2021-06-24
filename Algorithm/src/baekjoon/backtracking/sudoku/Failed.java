package baekjoon.backtracking.q2580;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Failed {

    static boolean[] visited;
    static int[][] sudoku = new int[9][9];
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int num;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                num = Integer.parseInt(st.nextToken());
                if (num == 0)
                    count++;
                sudoku[i][j] = num;
            }
        }

        sudoku(0, 0, 0);
        System.out.println("=====================");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                bw.write(sudoku[i][j] + " ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();

    }

    static void sudoku(int row, int col, int depth) {
        if (depth == count) {
            return;
        }

        int empty;
        int r = 0, c = 0;
        // 가로 확인
        for (int i = 0; i < 9; i++) {
            empty = 0;
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] == 0) {
                    empty++;
                    r = i;
                    c = j;
                }
            }
            if (empty == 1) {
                // 가로 채우기
                horizontal(r, c);
            }
        }

        // 세로 확인
        for (int i = 0; i < 9; i++) {
            empty = 0;
            for (int j = 0; j < 9; j++) {
                if (sudoku[j][i] == 0) {
                    empty++;
                    r = j;
                    c = i;
                }
            }
            if (empty == 1) {
                // 세로 채우기
                vertical(r, c);
            }
        }

        // 9칸 확인
        empty = 0;
        for (int i = row; i < 3; i++) {
            for (int j = col; j < 3; j++) {
                if (sudoku[i][j] == 0) {
                    empty++;
                }
            }
        }

        // 9칸 채우기
        if (empty == 1) {

        }
    }

    static void horizontal(int row, int col) {
        visited = new boolean[9];
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] > 0) {
                visited[sudoku[row][i] - 1] = true;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (visited[i] == false) {
                sudoku[row][col] = i + 1;
                return;
            }
        }

    }

    static void vertical(int row, int col) {
        visited = new boolean[9];
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] > 0) {
                visited[sudoku[i][col] - 1] = true;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (visited[i] == false) {
                sudoku[row][col] = i + 1;
                return;
            }
        }

    }

    static void square(int row, int col) {
        visited = new boolean[9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sudoku[i][j] > 0) {
                    visited[sudoku[i][j] - 1] = true;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (visited[i] == false) {
                sudoku[row][col] = i + 1;
                return;
            }
        }
    }

    static void print() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }
}
