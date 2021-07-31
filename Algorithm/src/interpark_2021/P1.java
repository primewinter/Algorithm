package interpark_2021;

public class P1 {
    public static void main(String[] args) throws Exception {
        int sl1 = 60;
        int[][] c1 = new int[][] {{60, 1}, {130, 2}, {240, 4}, {432, 7}};
        System.out.println(solution(sl1, c1)); // 2

        int sl2 = 30;
        int[][] c2 = new int[][] {{60, 3}, {152, 6}, {240, 9}};
        System.out.println(solution(sl2, c2)); // 1

    }

    public static int solution(int speed_limit, int[][] cameras) {
        int answer = 0;
        double distance, time, speed;

        // 첫 번째 구간 과속 여부 확인
        distance = cameras[0][0];
        time = cameras[0][1];
        speed = distance / time;

        if ( speed > speed_limit ) answer++;
        
        // 두 번째 구간부터 과속 여부 확인
        for(int i = 1 ; i < cameras.length; i++) {
            distance = cameras[i][0] - cameras[i-1][0];
            time = cameras[i][1] - cameras[i-1][1];
            speed = distance / time;

            if (speed > speed_limit) answer++;
        }

        return answer;
    }

}
