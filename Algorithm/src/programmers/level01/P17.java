package programmers.level01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class P17 {
	/* ���α׷��ӽ� Lv1. ũ���� �����̱� ����
	 * https://programmers.co.kr/learn/courses/30/lessons/64061
	 * ���� ����
	���Ӱ������� �Ҹ���� ũ���� �����̱� ��踦 ����� �������� ������� �մϴ�.
	�Ҹ���� ������ ��̸� ���̱� ���� ȭ�� ������ ��Ģ�� ������ ���� ���� ������ �ݿ��Ϸ��� �մϴ�.
	
	crane_game_101.png
	
	���� ȭ���� 1 x 1 ũ���� ĭ��� �̷���� N x N ũ���� ���簢 �����̸� ���ʿ��� ũ������ �ְ� �����ʿ��� �ٱ��ϰ� �ֽ��ϴ�. (�� �׸��� 5 x 5 ũ���� �����Դϴ�). �� ���� ĭ���� �پ��� ������ ��� ������ ������ ���� ĭ�� ��ĭ�Դϴ�. ��� ������ 1 x 1 ũ���� ���� �� ĭ�� �����ϸ� ������ ���� �Ʒ� ĭ���� �������� �׿� �ֽ��ϴ�. ���� ����ڴ� ũ������ �¿�� �������� ���� ��ġ���� ���� ���� �ִ� ������ ���� �ø� �� �ֽ��ϴ�. ���� �ø� ������ �ٱ��Ͽ� ���̰� �Ǵ� ��, �̶� �ٱ����� ���� �Ʒ� ĭ���� ������ ������� ���̰� �˴ϴ�. ���� �׸��� [1��, 5��, 3��] ��ġ���� ������� ������ ���� �÷� �ٱ��Ͽ� ���� ����Դϴ�.
	
	crane_game_102.png
	
	���� ���� ����� ���� �� ���� �ٱ��Ͽ� �����ؼ� ���̰� �Ǹ� �� ������ �Ͷ߷����鼭 �ٱ��Ͽ��� ������� �˴ϴ�. �� ���¿��� �̾ [5��] ��ġ���� ������ ���� �ٱ��Ͽ� ������ ���� ��� ���� �� ���� �������ϴ�.
	
	crane_game_103.gif
	
	ũ���� �۵� �� ������ �������� �ʴ� ���� ������ ���� ������ ���� ������ ũ������ �۵���Ű�� ��쿡�� �ƹ��� �ϵ� �Ͼ�� �ʽ��ϴ�. ���� �ٱ��ϴ� ��� ������ �� �� ���� ��ŭ ����� ũ�ٰ� �����մϴ�. (�׸������� ȭ��ǥ�� �������� 5ĭ������ ǥ���Ͽ���)
	
	���� ȭ���� ������ ���°� ��� 2���� �迭 board�� ������ ���� ���� ũ������ �۵���Ų ��ġ�� ��� �迭 moves�� �Ű������� �־��� ��, ũ������ ��� �۵���Ų �� ��Ʈ���� ����� ������ ������ return �ϵ��� solution �Լ��� �ϼ����ּ���.
	
	[���ѻ���]
	board �迭�� 2���� �迭�� ũ��� 5 x 5 �̻� 30 x 30 �����Դϴ�.
	board�� �� ĭ���� 0 �̻� 100 ������ ������ ����ֽ��ϴ�.
	0�� �� ĭ�� ��Ÿ���ϴ�.
	1 ~ 100�� �� ���ڴ� ���� �ٸ� ������ ����� �ǹ��ϸ� ���� ���ڴ� ���� ����� ������ ��Ÿ���ϴ�.
	moves �迭�� ũ��� 1 �̻� 1,000 �����Դϴ�.
	moves �迭 �� ���ҵ��� ���� 1 �̻��̸� board �迭�� ���� ũ�� ������ �ڿ����Դϴ�.
	����� ��
	board	moves	result
	[[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]	[1,5,3,5,1,2,1,4]	4
	����� ���� ���� ����
	����� �� #1
	
	������ ó�� ���´� ������ �־��� ���ÿ� �����ϴ�. ũ������ [1, 5, 3, 5, 1, 2, 1, 4] �� ��ġ���� ���ʴ�� ������ ��� �ٱ��Ͽ� �Ű� ���� ��, ���´� �Ʒ� �׸��� ������ �ٱ��Ͽ� ��� �������� ��Ʈ���� ����� ������ 4�� �Դϴ�.
	 */
	
	// ���� ������ ��
	 public static int solution(int[][] board, int[] moves) {
		 int answer = 0;
		 List<Queue<Integer>> queueList = new ArrayList<>();
		 //Map<Integer, Queue<Integer>> queueMap = new HashMap<>();
         for(int i=0; i<board.length; i++) {
             Queue<Integer> stack = new LinkedList<>();
             for(int j=0; j<board[0].length; j++) {
                 if(board[j][i]!=0) {
                     stack.add(board[j][i]);
                     //queueMap.put(i, stack);
                 }
             }
             queueList.add(stack);
         }       

         Stack<Integer> basket = new Stack<>();
         for(int move : moves) {
             //Integer doll = queueMap.get(move-1).poll();
        	 Integer doll = queueList.get(move-1).poll();
             if(doll!=null) {
                 if(basket.size()==0) {
                     basket.add(doll);
                 } else if(basket.size()!=0 && basket.peek()==doll) {
                     basket.pop();
                     answer+=2;
                 } else if(basket.size()!=0 && basket.peek()!=doll) {
                     basket.add(doll);
                 }
             }
         }         
         
         return answer;
    }
	 
	 //�ٸ� ��� ���� Ǯ��
	 public static int otherSolution(int[][] board, int[] moves) {
	        int answer = 0;
	        Stack<Integer> stack = new Stack<>();
	        for (int move : moves) {
	            for (int j = 0; j < board.length; j++) {
	                if (board[j][move - 1] != 0) {
	                    if (stack.isEmpty()) {
	                        stack.push(board[j][move - 1]);
	                        board[j][move - 1] = 0;
	                        break;
	                    }
	                    if (board[j][move - 1] == stack.peek()) {
	                        stack.pop();
	                        answer += 2;
	                    } else
	                        stack.push(board[j][move - 1]);
	                    board[j][move - 1] = 0;
	                    break;
	                }
	            }
	        }
	        return answer;
	    }
	
	 
	 
	public static void main(String[] args) {
		int[][] a = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[][] c = {{0,0},{0,0}};
		int[] b = {1,5,3,5,1,2,1,4};
		
		System.out.println("��� :"+solution(c,b));
	}
}
