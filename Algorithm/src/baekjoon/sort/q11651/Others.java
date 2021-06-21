package baekjoon.sort.q11651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * TITLE: BOJ 좌표 정렬하기2
 * 
 * URL: https://www.acmicpc.net/problem/11651
 * 
 * NOTE: Comparable<T> 이용해서 풀기
 */
public class Others {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Point[] arr = new Point[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            Point point = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            arr[i] = point;
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (Point p : arr) {
            sb.append(p.X).append(" " + p.Y).append("\n");
        }
        System.out.println(sb);
        br.close();

    }

    static class Point implements Comparable<Point> {
        int X;
        int Y;

        Point(int X, int Y) {
            this.X = X;
            this.Y = Y;
        }

        @Override
        public int compareTo(Point o2) {
            if (o2.Y != Y) {
                return Integer.compare(Y, o2.Y);
            } else {
                return Integer.compare(X, o2.X);
            }
        }
    }

}
