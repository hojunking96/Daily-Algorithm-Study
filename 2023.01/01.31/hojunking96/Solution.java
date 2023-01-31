import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
         Map<Integer, Integer> map = new HashMap<>();
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        for (int i = 0; i < 6; i++) {
            map.put(win_nums[i], 1);
        }
        int cnt = 0;
        int zeroCnt = 0;
        for (int num : lottos) {
            if (map.containsKey(num)) {
                cnt++;
            }
            if (num == 0) {
                zeroCnt++;
            }
        }
        int maxWinCnt = cnt + zeroCnt;
        int minWinCnt = cnt;
        int[] answer = {rank[maxWinCnt], rank[minWinCnt]};
        return answer;
    }
}
