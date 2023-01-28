
public class Solution {
    public int solution(int storey) {
        int answer = 0;
        String number = String.valueOf(storey);
        char[] arr = number.toCharArray();
        int[] ints = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ints[i] = arr[i] - '0';
        }
        for (int i = ints.length - 1; i >= 0; i--) {
            int anInt = ints[i];
            if (anInt == 10) {
                if (i - 1 < 0) {
                    answer += 1;
                    continue;
                }
                ints[i - 1]++;
                continue;
            }

            if(anInt >= 6) {
                answer += (10 - anInt);
                if(i - 1 < 0) {
                    answer += 1;
                    continue;
                }
                ints[i - 1]++;
            } else if(anInt <= 4) {
                answer += anInt;
            } else if(anInt == 5) {
                if(i - 1 < 0) {
                    answer += 5;
                }else {
                    if (ints[i - 1] < 5) {
                        answer += anInt;
                    }else {
                        answer += 5;
                        ints[i - 1]++;
                    }
                }
            }
        }
        return answer;
    }
}
