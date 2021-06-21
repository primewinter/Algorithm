package baekjoon.sort.q11651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * TITLE: BOJ 좌표 정렬하기2
 * 
 * URL: https://www.acmicpc.net/problem/11651
 * 
 * NOTE: Comparator<T> 이용해서 풀기
 */
public class Q11651 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Point> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            Point point = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            list.add(point);
        }

        Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o2.Y > o1.Y) {
                    return -1;
                }
                if (o2.Y == o1.Y) {
                    if (o2.X > o1.X) {
                        return -1;
                    }
                    if (o2.X < o1.X) {
                        return 1;
                    }
                    return 0;
                }
                return 1;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Point p : list) {
            sb.append(p.X).append(" " + p.Y).append("\n");
        }
        System.out.println(sb);
        br.close();

    }

    static class Point {
        int X;
        int Y;

        Point(int X, int Y) {
            this.X = X;
            this.Y = Y;
        }
    }

}
