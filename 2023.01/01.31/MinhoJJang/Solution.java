/*
 * Algorithm Study 23/1/31 problem
 * https://school.programmers.co.kr/learn/courses/30/lessons/77484?language=java
 * 로또 최고 순위와 최저 순위
 */

 /*
  예상 난이도: 하

  풀이법 생각: 0을 제외한 나머지 숫자들 중, 당첨된 개수를 체크한다. 그 개수가 최저 등수이고 최저등수+0의 개수가 최대 등수이다.
  */
public class Solution {

    static final int numbers = 6;
    static final int best = 0;
    static final int least = 1;
    static int same_count = 0;
    static int zero_count = 0;
     public int[] solution(int[] lottos, int[] win_nums) {
         int[] answer = new int[2];

         for(int i=0; i<numbers; i++){

             if(lottos[i] == 0){
                 // 로또 숫자가 0일 경우 zero_count를 1씩 증가시킨다.
                 zero_count++;
             }
             else{
                 // 로또 숫자가 0이 아닐 경우 당첨되었는지 확인한다. 당첨되었을 경우 same_count를 1씩 증가시킨다.
                 for(int j=0; j<numbers; j++){
                     if(win_nums[j] == lottos[i]){
                         same_count++;
                         break;
                     }
                 }
             }
         }

        /*
           먼저, 최저 순위(이하 least_score)의 경우 same_count(이하 sc)에 기반한다. sc가 0~1일 경우 6등, 2일 경우 5등, 3일 경우 4등 ... 6일 경우 1등이다. 즉 least_score는 7-sc인데 다만 sc가 0일 경우만 따로 계산해주면 된다.

           최고 순위(이하 best_score)는 least_score + zero_count(이하 zc)에 기반한다. sc가 0일때를 제외하고는 best_score = least_score + zc 이다.
           또한 zc 역시 2개 이상이어야 등수가 늘어나므로 이 역시 나눠서 계산한다.
         */

         if(same_count != 0){
             answer[best] = 7-same_count-zero_count;
             answer[least] = 7-same_count;
         }
         else{
             answer[least] = 6;

             if(zero_count >= 2){
                 answer[best] = 7-zero_count;
             }
             else{
                 answer[best] = 6;
             }
         }

         return answer;
     }
}

// 100점