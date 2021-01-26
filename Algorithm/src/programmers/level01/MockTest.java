package programmers.level01;

public class MockTest {
	
	public int[] solution(int[] answers) {
        int[] aAnswers = {1,2,3,4,5};
        int[] bAnswers = {2,1,2,3,2,4,2,5};
        int[] cAnswers = {3,3,1,1,2,2,4,4,5,5};
        int a = 0;
        int b = 0;
        int c = 0;
        for(int i=0;i<answers.length;i++) {
            if(answers[i]==aAnswers[i%5]) a++;
            if(answers[i]==bAnswers[i%8]) b++;
            if(answers[i]==cAnswers[i%10]) c++;
        }

        int[] point = sort(new int[]{a,b,c});
        if(point[0]==point[1]) {
            if(point[1]==point[2]) {
                return new int[]{1,2,3};
            } else {
                if(point[2]==a) return new int[]{2,3};
                else if(point[2]==b) return new int[]{1,3};
                else return new int[]{1,2};
            }
        } else {
            if(point[0]==a) return new int[]{1};
            else if(point[0]==b) return new int[]{2};
            else return new int[]{3};
        }
    }

    public int[] sort(int [] arr) {
        for(int i=0;i<arr.length-1;i++) {
            for(int j=1;j<arr.length-i;j++) {
                if(arr[j-1]<arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        return arr;
    }

}
