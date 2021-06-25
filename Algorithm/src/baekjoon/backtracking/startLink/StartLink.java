package baekjoon.backtracking.startLink;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StartLink {

    static int[][] matrix;
    static int N;
    static int[] arr;
    static boolean[] team;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        team = new boolean[N];
        arr = new int[N / 2];
        matrix = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        arr[0] = 0;
        team[0] = true;

        divideTeam(1, 1);
        System.out.println(min);
        br.close();
    }

    // (n - 1)개 중에서 (n / 2 - 1)개를 뽑으면 된다.
    // ex) N = 4 일 경우, 3개 중에서 1개를 뽑으면 된다.
    // ex) N = 6 일 경우, 5개 중에서 2개를 뽑으면 된다.
    static void divideTeam(int idx, int picked) {

        if (picked == N / 2) {

            int start = getScore(arr);
            int link = getScore(getReversed());
            int diff = Math.abs(start - link);

            min = Integer.min(min, diff);

            return;
        }
        for (int i = idx; i < N; i++) {
            if (i > arr[idx - 1]) {
                arr[idx] = i;
                team[i] = true;
                divideTeam(idx + 1, picked + 1);
                team[i] = false;
            }
        }
    }

    static int[] getReversed() {
        int[] temp = new int[N / 2];
        int k = 0;
        for (int i = 0; i < N; i++) {
            if (!team[i]) {
                temp[k] = i;
                k++;
            }
            if (k == N / 2)
                break;
        }
        return temp;
    }

    static int getScore(int[] array) {
        int score = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                score += matrix[array[i]][array[j]];
            }
        }
        return score;
    }

}
