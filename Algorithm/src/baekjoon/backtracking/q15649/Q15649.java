package q15649;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

class Q15649 {

    static boolean[] visit;
    static int[] arr;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = sc.nextInt();
        int M = sc.nextInt();

        visit = new boolean[N];
        arr = new int[M];

        backtracking(N, M, 0);

        bw.flush();
        bw.close();
        sc.close();
    }

    public static void backtracking(int N, int M, int depth) throws IOException {
        
        // 재귀의 깊이가 M과 같아지면 탐색과정에서 담았던 배열을 출력한다.
        if( depth == M ) {

            for(int val : arr) {
                bw.write(String.valueOf(val)+" ");
            }

            bw.newLine();
            return;
        }

        for(int i = 0; i < N ; i++) {

            // 방문한 적이 없는 노드라면
            if( visit[i] == false ) {

                visit[i] = true; // 방문상태로 변경
                arr[depth] = i + 1; // 해당 깊이를 index 로 하여 i+1 값 저장
                backtracking(N, M, depth+1); // 다음 자식 노드 방문을 위해 depth를 1 증가시켜서 재귀호출

                // 자식노드 방문이 끝나고 돌아오면 방문노드를 방문하지 않은 상태로 변경
                visit[i] = false;
            }

        }

        return;
    }
}