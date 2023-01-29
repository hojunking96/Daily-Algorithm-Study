class Solution {
    public int solution(int storey) {
      int answer = 0;
        while (storey > 0) {

            int lastNum = storey % 10;
            if (lastNum == 5) {
                if (isDown(storey)) {
                    answer += lastNum;
                } else {
                    answer += (10 - lastNum);
                    storey += 10;
                }
            } else if (lastNum < 5) {
                answer += lastNum;
            } else {
                answer += (10 - lastNum);
                storey += 10;
            }
            storey /= 10;
        }
        return answer;
    }
    
    
    public static boolean isDown(int storey) {
         return ((storey / 10) % 10) < 5;
    }
}
