package baekjoon.backtracking.q9663;

import java.io.IOException;
import java.util.Scanner;

/**
 * TITLE: BOJ N-Queen
 * 
 * URL: https://www.acmicpc.net/problem/9663
 */
public class Failed {

    static int N;
    static int cases;
    static boolean[][] board;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        board = new boolean[N][N];
        moveQueen(0, 0, 0);

        System.out.println(cases);
        sc.close();
    }

    static void moveQueen(int row, int col, int depth) {

        // 이동한 퀸이 N번째 퀸이었다면 종료
        if (depth == N) {
            cases++;
            return;
        }

        // 그 다음 이동할 곳으로 가서 재귀호출
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (board[i][j] == false) {
                    // fillChess(i, j, true);
                    board[i][j] = true;
                    moveQueen(i, j, depth + 1);
                    // fillChess(i, j, false);
                    board[i][j] = false;
                }

            }
        }

    }

    // 뒤늦게 퀸은 가로, 세로, 대각선으로 칸 수 상관없이 이동 가능하다는 것을 알고 구현하려고 한 메서드
    // 대각선을 뽑아내는 로직은 구현하지 못했다.
    static void fillChess(int row, int col, boolean toBe) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == row)
                    board[i][j] = toBe;
                if (j == col)
                    board[i][j] = toBe;
                /**
                 * 오답 이유1
                 * 
                 * 2차원배열로 하려고 했는데 row와 col을 중심으로 대각선을 뽑아내는 로직을 구현하지 못했다.
                 * 
                 * 다른 답을 찾아보니 어차피 한 행에 하나만 넣을 수 있으므로 열만 고려하면 되었다.
                 **/
            }
        }
    }

    // for debugging
    static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] == true ? 'O' : 'X');
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * 오답 이유2
     * 
     * 퀸은 가로, 세로, 대각선 어느 방향이든 한 칸씩만 이동하는 게 아니라
     * 
     * 끝까지 이동할 수 있다는 것을 알지 못했다.
     * 
     * 이동 가능한지 먼저 체크하는 것은 좋은 시도였으나 결과적으로는 틀린 메서드다.
     */
    // row, col을 기준으로 주위 최대 8칸에 다른 퀸이 있는지 확인하는 메서드
    static boolean canMove(int row, int col) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0)
                    continue;

                if (inRange(row + i, col + j) && board[row + i][col + j] == true) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean inRange(int row, int col) {
        if (row >= 0 && row < N && col >= 0 && col < N)
            return true;
        return false;
    }
}
