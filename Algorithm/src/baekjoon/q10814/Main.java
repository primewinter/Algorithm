package baekjoon.q10814;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    /**
     * TITLE: BOJ 나이순 정렬
     * URL: https://www.acmicpc.net/problem/10814
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<User> list = new ArrayList<>();
        StringTokenizer st;
        User user;
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            user = new User(i, Integer.parseInt(st.nextToken()), st.nextToken());
            list.add(user);
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for( User u : list ) {
            sb.append(u.age+" ").append(u.name).append("\n");
        }
        
        System.out.println(sb);
        br.close();

    }

    static class User implements Comparable<User>{
        int order;
        int age;
        String name;

        User(int order, int age, String name) {
            this.order = order;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(User u) {
            if( this.age > u.age ) {
                return 1; // age에 대해서 오름차순
            }
            else if ( this.age == u.age ) {
                if( this.order > u.order ) { // order에 대해서 오름차순
                    return 1;
                }
            }
            return -1;
        }
    }
   

}

