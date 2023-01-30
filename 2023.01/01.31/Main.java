import java.util.Scanner;

/*
 * Algorithm Study 23/1/31 problem
 * https://school.programmers.co.kr/learn/courses/30/lessons/77484?language=java
 * 로또 최고 순위와 최저 순위
 */

 /*
  예상 난이도: 하

  풀이법 생각: 0을 제외한 나머지 숫자들 중, 당첨된 개수를 체크한다. 그 개수가 최저 등수이고 최저등수+0의 개수가 최대 등수이다. 
  */

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        final int numbers = 6;
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        int[] lottos = new int[numbers];
        int[] win_nums = new int[numbers];

        for(int i=0; i<numbers; i++){
            lottos[i] = sc.nextInt();
        } 

        for(int i=0; i<numbers; i++){
            win_nums[i] = sc.nextInt();
        } 

        


    }
}
