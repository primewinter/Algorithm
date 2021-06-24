package baekjoon.backtracking.sudoku;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * TITLE: BOJ 스도쿠
 * 
 * URL: https://www.acmicpc.net/problem/2580
 */
public class Q2580 {

    static int[][] board = new int[9][9];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sudoku(0, 0);

    }

    static void sudoku(int row, int col) throws IOException {

        // 해당 행이 다 채워졌을 경우 다음 행의 첫 번째 열부터 시작
        if (col == 9) {
            sudoku(row + 1, 0);
            return;
        }

        // 행과 열이 모두 채워졌을 경우 출력 후 종료
        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    bw.write(board[i][j] + " ");
                }
                bw.newLine();
            }

            bw.flush();
            bw.close();
            System.exit(0);
        }

        if (board[row][col] == 0) {
            // 만약 해당 위치가 0이라면 1부터 9까지 중 가능한 수 탐색
            for (int i = 1; i <= 9; i++) {
                if (checkHorizontal(row, col, i) && checkVertical(row, col, i) && checkSquare(row, col, i)) {
                    board[row][col] = i;
                    sudoku(row, col + 1);
                }
            }
            // 못 찾을 경우 초기화하고 리턴
            board[row][col] = 0;
            return;
        }

        sudoku(row, col + 1);

    }

    static boolean checkHorizontal(int row, int col, int value) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value) {
                return false;
            }
        }
        return true;
    }

    static boolean checkVertical(int row, int col, int value) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == value) {
                return false;
            }
        }
        return true;
    }

    static boolean checkSquare(int row, int col, int value) {
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

}
