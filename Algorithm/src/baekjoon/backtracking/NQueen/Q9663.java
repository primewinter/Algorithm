package baekjoon.backtracking.NQueen;

import java.io.IOException;
import java.util.Scanner;

/**
 * TITLE: BOJ N-Queen
 * 
 * URL: https://www.acmicpc.net/problem/9663
 */
public class Q9663 {

    static int N;
    static int cases;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        // idx = '열', 원소 값 = '행'
        // ex) arr[0] = 3 이면, N x N 체스판에서 (0, 3) 위치에 퀸이 놓여 있다는 뜻이다.
        // 어차피 각 행에 하나의 퀸만 올 수 있기 때문에 2차원 배열이 아니라 1차원 배열로 해도 충분하다.
        arr = new int[N];

        // moveQueen의 인자는 col로 이를 테면 '열'과 같은 의미를 갖는다.
        moveQueen(0);

        System.out.println(cases);
        sc.close();
    }

    static void moveQueen(int col) {

        if (col == N) {
            cases++;
            return;
        }

        // col열(arr의 인덱스값 = col)에서 몇 번째 행에 놓을 수 있는지 확인
        for (int i = 0; i < N; i++) {

            arr[col] = i;
            if (canMove(col)) {
                moveQueen(col + 1);
            }

        }
    }

    static boolean canMove(int col) {
        // 기준(col) 전까지만 탐색
        for (int i = 0; i < col; i++) {
            // 기준과 같은 행에 있는 경우
            if (arr[col] == arr[i])
                return false;

            // 대각선에 있는 경우
            // (기준의 열과 i열 차이 = 기준의 행과 arr[i]행 차이) 인 경우
            if (Math.abs(col - i) == Math.abs(arr[col] - arr[i]))
                return false;
        }
        return true;
    }

}
