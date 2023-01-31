import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        HashSet<Integer> set = new HashSet<>();
        int hit = 0; int zero = 0;
        for (int i = 0; i < win_nums.length; i++) set.add(win_nums[i]);

        for (int i = 0; i < lottos.length; i++) {
            if(lottos[i] ==0) zero++;
            else if(set.contains(lottos[i])) hit++;
        }
        if(hit == 0) answer[1] = 6;
        else answer[1] = 7-hit;
        hit += zero;
        if(hit == 0) answer[0] = 6;
        else answer[0] = 7-hit;
        return answer;
    }

    public static void main(String[] args) {
        로또의최고순위와최저순위 a = new 로또의최고순위와최저순위();
        int[] lottos = {45, 4, 35, 20, 3, 9};
        int[] win_nums = {20, 9, 3, 45, 4, 35};
        System.out.println(Arrays.toString(a.solution(lottos,win_nums)));
    }
}
